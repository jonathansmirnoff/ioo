package cochera;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class ModificarAbonoView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private SistemaAdministracionCochera sistema;

	public ModificarAbonoView(SistemaAdministracionCochera sist) {
		setVisible(true);
		sistema = sist;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNewLabel = new JLabel("Tama\u00F1o");
		JLabel lblNewLabel_1 = new JLabel("Precio");
		JLabel lblNewLabel_2 = new JLabel("Periodo");
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();
		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblModificacionDeAbono = new JLabel("Modificacion de abonos");
		lblModificacionDeAbono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(
						gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPanel.createSequentialGroup()
												.addGroup(gl_contentPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(85)
																.addGroup(gl_contentPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblNewLabel)
																		.addComponent(lblNewLabel_2)
																		.addComponent(lblNewLabel_1))
												.addGap(109)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(textField)
														.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
												.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(114)
								.addComponent(lblModificacionDeAbono))).addContainerGap(65, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblModificacionDeAbono)
						.addGap(27)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addContainerGap(49, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						sistema.modificarAbono(comboBox.getSelectedItem().toString(),
								Float.parseFloat(textField.getText()), comboBox_1.getSelectedItem().toString());
						Abono_menu abmen = new Abono_menu(sistema);
						dispose();
					}
				});

			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Abono_menu abmen = new Abono_menu(sistema);
						dispose();
					}
				});

			}
		}

		Iterator<Abono> abon = sistema.getAbonos().iterator();
		Abono aux;
		int flag_tam, flag_per;
		Vector<Abono> Vaux = new Vector<Abono>();
		Vector<Abono> Vaux2 = new Vector<Abono>();
		Iterator<Abono> itaux;
		while (abon.hasNext()) {
			flag_tam = 0;
			flag_per = 0;
			aux = abon.next();
			Vaux.addElement(aux);
			itaux = Vaux2.iterator();
			while (itaux.hasNext() && (flag_tam == 0 || flag_per == 0)) {
				Abono aux2 = itaux.next();
				if (aux.getTamano() == aux2.getTamano() && aux.getPeriodo() == aux2.getPeriodo()) {
					flag_tam = 1;
					flag_per = 1;
				}
				if (aux.getTamano() == aux2.getTamano() && aux.getPeriodo() != aux2.getPeriodo())
					flag_tam = 1;
				if (aux.getTamano() != aux2.getTamano() && aux.getPeriodo() == aux2.getPeriodo())
					flag_per = 1;
			}
			if (flag_tam != 1 || flag_per != 1) {
				Vaux2.addElement(aux);

				if (flag_tam == 0 && flag_per == 0) {
					comboBox.addItem(aux.getTamano());
					comboBox_1.addItem(aux.getPeriodo());
				}
				if (flag_tam == 1 && flag_per == 0)
					comboBox_1.addItem(aux.getPeriodo());
				if (flag_tam == 0 && flag_per == 1)
					comboBox.addItem(aux.getTamano());
			}

		}
	}

}
