package cochera;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AltaContratoView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SistemaAdministracionCochera sistema;
	private JTextField textField_cli;
	private JTextField textField_coch;
	private JTextField textField_paten;
	private JTextField textCampo1;
	private JTextField textFieldVencim;

	public AltaContratoView(SistemaAdministracionCochera sist) {
		sistema = sist;
		setVisible(true);
		setBounds(100, 100, 450, 505);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblContrato = new JLabel("Alta de contrato");
		lblContrato.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JLabel lblNewLabel = new JLabel("Tipo:");
		JLabel lblclie = new JLabel("*DNI cliente:");
		JLabel lblCoche = new JLabel("*ID cochera:");
		JLabel lblTam = new JLabel("Tama\u00F1o:");
		JLabel lblPeriodo = new JLabel("Periodo:");
		textField_cli = new JTextField();
		textField_cli.setColumns(10);
		textField_coch = new JTextField();
		textField_coch.setColumns(10);

		JComboBox comboBox_tipo = new JComboBox();

		JLabel lblPatente = new JLabel("Patente:");

		textField_paten = new JTextField();
		textField_paten.setColumns(10);

		JComboBox comboBox_per = new JComboBox();
		comboBox_per.setModel(new DefaultComboBoxModel());

		Iterator<Abono> abon = sistema.getAbonos().iterator();//
		Abono auxab;
		int flagab;
		Vector<Abono> Vauxab = new Vector<Abono>();
		Iterator<Abono> itauxab;
		while (abon.hasNext()) {
			flagab = 0;
			auxab = abon.next();
			if (auxab.getEstado() == 1) {
				itauxab = Vauxab.iterator();
				while (itauxab.hasNext() && flagab == 0)
					if (auxab.getPeriodo() == itauxab.next().getPeriodo())
						flagab = 1;
				if (flagab == 0) {
					Vauxab.addElement(auxab);
					comboBox_per.addItem(auxab.getPeriodo());
				}
			}
		}

		JLabel lblEntidad = new JLabel("Entidad:");
		JComboBox comboBox_entidad = new JComboBox();

		JLabel lblCampo1 = new JLabel("campo1");

		JComboBox comboBox_tam = new JComboBox();

		Iterator<Cochera> coch = sistema.getCocheras().iterator();//
		Cochera auxco;
		int flagco;
		Vector<Cochera> Vauxco = new Vector<Cochera>();
		Iterator<Cochera> itauxco;
		while (coch.hasNext()) {
			flagco = 0;
			auxco = coch.next();
			if (auxco.getEstaOcupada() != true) {
				itauxco = Vauxco.iterator();
				while (itauxco.hasNext() && flagco == 0)
					if (auxco.getTamano() == itauxco.next().getTamano())
						flagco = 1;
				if (flagco == 0) {
					Vauxco.addElement(auxco);
					comboBox_tam.addItem(auxco.getTamano());
				}
			}
		}

		textCampo1 = new JTextField();
		textCampo1.setColumns(10);
		JLabel lblVencimiento = new JLabel("Fecha vencimiento:");
		textFieldVencim = new JTextField();
		textFieldVencim.setColumns(10);
		lblCampo1.setVisible(false);
		textCampo1.setVisible(false);
		lblVencimiento.setVisible(false);
		textFieldVencim.setVisible(false);
		lblEntidad.setVisible(false);

		Iterator<MedioDePago> mdp = sistema.getMediosDePago().iterator();
		MedioDePago aux;
		int flag;
		Vector<MedioDePago> Vaux = new Vector<MedioDePago>();
		Iterator<MedioDePago> itaux;
		while (mdp.hasNext()) {
			flag = 0;
			aux = mdp.next();
			itaux = Vaux.iterator();
			if (aux.getEstado() == 1) {
				while (itaux.hasNext() && flag == 0) {
					MedioDePago aux2 = itaux.next();
					if (aux.getTipo() == aux2.getTipo())
						flag = 1;
				}
				if (flag == 0) {
					comboBox_tipo.addItem(aux.getTipo());
					Vaux.addElement(aux);
				}
			}

		}

		comboBox_tipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_tipo.getSelectedItem().toString().compareTo("Efectivo") == 0
						|| comboBox_tipo.getSelectedItem().toString().compareTo("Cheque") == 0) {
					lblEntidad.setVisible(false);
					comboBox_entidad.setVisible(false);
					lblCampo1.setVisible(false);
					textCampo1.setVisible(false);
					lblVencimiento.setVisible(false);
					textFieldVencim.setVisible(false);
				} else {
					lblEntidad.setVisible(true);
					comboBox_entidad.setVisible(true);
					lblCampo1.setVisible(true);
					textCampo1.setVisible(true);
					lblVencimiento.setVisible(false);
					textFieldVencim.setVisible(false);
					if (comboBox_tipo.getSelectedItem().toString().compareTo("Debito CBU") == 0) {
						lblCampo1.setText("cbu:");

						comboBox_entidad.removeAllItems();
						Iterator<MedioDePago> mdp = sistema.getMediosDePago().iterator();
						MedioDePago aux;
						int flag;
						Vector<MedioDePago> Vaux = new Vector<MedioDePago>();
						Iterator<MedioDePago> itaux;
						while (mdp.hasNext()) {
							flag = 0;
							aux = mdp.next();
							if (aux.getEstado() == 1) {
								if (aux.getTipo().compareTo("Debito CBU") == 0) {
									itaux = Vaux.iterator();
									while (itaux.hasNext() && flag == 0) {
										MedioDePago aux2 = itaux.next();
										if (aux.getEntidad() == aux2.getEntidad())
											flag = 1;
									}
									if (flag == 0) {
										comboBox_entidad.addItem(aux.getEntidad());
										Vaux.addElement(aux);
									}
								}
							}

						}

					} else {
						lblCampo1.setText("Numero:");
						lblVencimiento.setVisible(true);
						textFieldVencim.setVisible(true);

						Iterator<MedioDePago> mdp = sistema.getMediosDePago().iterator();
						MedioDePago aux;
						int flag;
						Vector<MedioDePago> Vaux = new Vector<MedioDePago>();
						Iterator<MedioDePago> itaux;
						comboBox_entidad.removeAllItems();
						while (mdp.hasNext()) {
							flag = 0;
							aux = mdp.next();
							if (aux.getEstado() == 1) {
								if (aux.getTipo().compareTo("Tarjeta de credito") == 0) {
									itaux = Vaux.iterator();
									while (itaux.hasNext() && flag == 0) {
										MedioDePago aux2 = itaux.next();
										if (aux.getEntidad() == aux2.getEntidad())
											flag = 1;
									}
									if (flag == 0) {
										if (aux.getEstado() == 1) {
											comboBox_entidad.addItem(aux.getEntidad());
											Vaux.addElement(aux);
										}
									}
								}
							}

						}

					}

				}

			}
		});

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(57)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addComponent(lblclie).addComponent(lblTam).addComponent(lblCoche)
								.addComponent(lblPeriodo).addComponent(lblPatente).addComponent(lblEntidad)
								.addComponent(lblVencimiento).addComponent(lblCampo1))
						.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox_entidad, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox_tam, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldVencim).addComponent(textCampo1)
								.addComponent(comboBox_per, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_paten).addComponent(textField_cli).addComponent(textField_coch)
								.addComponent(comboBox_tipo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(92, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(142).addComponent(lblContrato)
						.addContainerGap(154, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblContrato).addGap(23)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(comboBox_tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblclie).addComponent(
						textField_cli, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblCoche).addComponent(
						textField_coch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(12)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblTam).addComponent(
						comboBox_tam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblPeriodo).addComponent(
						comboBox_per, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblPatente).addComponent(
						textField_paten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblEntidad).addComponent(
						comboBox_entidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCampo1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCampo1))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblVencimiento)
						.addComponent(textFieldVencim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addContainerGap(57, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// Contrato efectivo
						if (comboBox_tipo.getSelectedItem().toString().compareTo("Efectivo") == 0)
							sistema.altaContratoEfectivo(textField_cli.getText(), textField_coch.getText(),
									comboBox_tam.getSelectedItem().toString(),
									comboBox_per.getSelectedItem().toString(), textField_paten.getText());

						// Contrato Cheque
						if (comboBox_tipo.getSelectedItem().toString().compareTo("Cheque") == 0)
							sistema.altaContratoCheque(textField_cli.getText(), textField_coch.getText(),
									comboBox_tam.getSelectedItem().toString(),
									comboBox_per.getSelectedItem().toString(), textField_paten.getText());

						// Contrato credito
						if (comboBox_tipo.getSelectedItem().toString().compareTo("Tarjeta de credito") == 0) {
							String fecha = textField_paten.getText();
							DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
							try {

								sistema.altaContratoDebitoTarjetaCredito(textField_cli.getText(),
										textField_coch.getText(), comboBox_tam.getSelectedItem().toString(),
										comboBox_per.getSelectedItem().toString(), textField_paten.getText(),
										comboBox_entidad.getSelectedItem().toString(), textCampo1.getText(),
										df.parse(fecha));
							} catch (Exception a) {
								a.printStackTrace();
							}
						}
						// Contrato Debito CBU
						if (comboBox_tipo.getSelectedItem().toString().compareTo("Debito CBU") == 0) {

							sistema.altaContratoDebitoCBU(textField_cli.getText(), textField_coch.getText(),
									comboBox_tam.getSelectedItem().toString(),
									comboBox_per.getSelectedItem().toString(), textField_paten.getText(),
									comboBox_entidad.getSelectedItem().toString(), textCampo1.getText());
						}
						Contrato_menu clmenu = new Contrato_menu(sistema);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Contrato_menu clmenu = new Contrato_menu(sistema);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
