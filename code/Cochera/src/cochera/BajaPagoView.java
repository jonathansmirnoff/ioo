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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class BajaPagoView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SistemaAdministracionCochera sistema;

	public BajaPagoView(SistemaAdministracionCochera sist) {
		sistema = sist;
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblBajaDeMedio = new JLabel("Baja de medio de pago");
		lblBajaDeMedio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBajaDeMedio.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCampo = new JLabel("campo");
		lblCampo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampo.setVisible(false);
		JComboBox comboBox_1 = new JComboBox();
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().toString().compareTo("Debito CBU") != 0
						&& comboBox.getSelectedItem().toString().compareTo("Tarjeta de credito") != 0) {
					lblCampo.setVisible(false);
					comboBox_1.setVisible(false);
				}

				if (comboBox.getSelectedItem().toString().compareTo("Debito CBU") == 0) {
					lblCampo.setText("Entidad emisora:");
					lblCampo.setVisible(true);
					comboBox_1.setVisible(true);
					comboBox_1.removeAllItems();

					Iterator<MedioDePago> mdp = sistema.getMediosDePago().iterator();
					MedioDePago aux;
					int flag;
					Vector<MedioDePago> Vaux = new Vector<MedioDePago>();
					Iterator<MedioDePago> itaux;
					comboBox_1.removeAllItems();
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
									comboBox_1.addItem(aux.getEntidad());
									Vaux.addElement(aux);
								}
							}
						}

					}

				}
				if (comboBox.getSelectedItem().toString().compareTo("Tarjeta de credito") == 0) {
					lblCampo.setText("Entidad bancaria:");
					lblCampo.setVisible(true);
					comboBox_1.setVisible(true);

					Iterator<MedioDePago> mdp = sistema.getMediosDePago().iterator();
					MedioDePago aux;
					int flag;
					Vector<MedioDePago> Vaux = new Vector<MedioDePago>();
					Iterator<MedioDePago> itaux;
					comboBox_1.removeAllItems();
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
										comboBox_1.addItem(aux.getEntidad());
										Vaux.addElement(aux);
									}
								}
							}
						}
					}

				}
			}
		});

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(118).addComponent(lblBajaDeMedio)
						.addContainerGap(121, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(98, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblTipo)
								.addComponent(lblCampo))
						.addGap(74)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 142, Short.MAX_VALUE))
						.addGap(70)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addContainerGap().addComponent(lblBajaDeMedio).addGap(29)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblTipo).addComponent(
						comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblCampo).addComponent(
						comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(82, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (comboBox_1.isVisible() == true)
							sistema.bajaMedioDePago(comboBox.getSelectedItem().toString(),
									comboBox_1.getSelectedItem().toString());
						else
							sistema.bajaMedioDePago(comboBox.getSelectedItem().toString(), "");
						MedioPago_menu mpmen = new MedioPago_menu(sistema);
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
						MedioPago_menu mpmen = new MedioPago_menu(sistema);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		Iterator<MedioDePago> mdp = sistema.getMediosDePago().iterator();
		MedioDePago aux;
		int flag;
		Vector<MedioDePago> Vaux = new Vector<MedioDePago>();
		Iterator<MedioDePago> itaux;
		while (mdp.hasNext()) {
			flag = 0;
			aux = mdp.next();
			if (aux.getEstado() == 1) {
				itaux = Vaux.iterator();
				while (itaux.hasNext() && flag == 0) {
					MedioDePago aux2 = itaux.next();
					if (aux.getTipo() == aux2.getTipo())
						flag = 1;
				}
				if (flag == 0) {
					comboBox.addItem(aux.getTipo());
					Vaux.addElement(aux);
				}

			}
		}

	}
}
