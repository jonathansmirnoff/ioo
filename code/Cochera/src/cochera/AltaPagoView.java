package cochera;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
/*import com.jgoodies.forms.factories.DefaultComponentFactory;*/
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AltaPagoView extends JDialog {

	private SistemaAdministracionCochera sistema;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the dialog.
	 */
	public AltaPagoView(SistemaAdministracionCochera sist) {
		sistema = sist;
		this.setVisible(true);

		setBounds(100, 100, 450, 400);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCampo = new JLabel("campo1");
		lblCampo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCampo_1 = new JLabel("campo2");
		lblCampo_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCampo_2 = new JLabel("campo3");
		lblCampo_2.setHorizontalAlignment(SwingConstants.CENTER);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);

		lblCampo.setVisible(false);
		lblCampo_1.setVisible(false);
		lblCampo_2.setVisible(false);
		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().compareTo("Debito CBU") != 0
						&& comboBox.getSelectedItem().toString().compareTo("Tarjeta de credito") != 0) {
					lblCampo.setVisible(false);
					lblCampo_2.setVisible(false);
					lblCampo_1.setVisible(false);
					textField.setVisible(false);
					textField_1.setVisible(false);
					textField_2.setVisible(false);
				}

				if (comboBox.getSelectedItem().toString().compareTo("Debito CBU") == 0) {
					lblCampo.setText("Entidad emisora:");
					lblCampo.setVisible(true);
					lblCampo_1.setText("CBU:");
					lblCampo_1.setVisible(true);
					lblCampo_2.setText("Fecha de vencimiento:");
					lblCampo_2.setVisible(true);
					textField.setVisible(true);
					textField_1.setVisible(true);
					textField_2.setVisible(true);
				}
				if (comboBox.getSelectedItem().toString().compareTo("Tarjeta de credito") == 0) {
					lblCampo.setText("Entidad bancaria:");
					lblCampo.setVisible(true);
					lblCampo_1.setText("Numero:");
					lblCampo_1.setVisible(true);
					lblCampo_2.setText("Fecha de vencimiento:");
					lblCampo_2.setVisible(true);
					textField.setVisible(true);
					textField_1.setVisible(true);
					textField_2.setVisible(true);
				}

			}
		});

		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Efectivo", "Cheque", "Tarjeta de credito", "Debito CBU" }));

		JLabel lblAltaDeMedio = new JLabel("Alta de medio de pago");
		lblAltaDeMedio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltaDeMedio.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedioPago_menu mpmen = new MedioPago_menu(sistema);
				dispose();
			}
		});

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.altaMedioDePago(comboBox.getSelectedItem().toString(), textField.getText());
				MedioPago_menu mpmen = new MedioPago_menu(sistema);
				dispose();
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout
								.createParallelGroup(
										Alignment.TRAILING)
								.addGroup(
										groupLayout.createSequentialGroup()
												.addGroup(
														groupLayout.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup()
																		.addGap(124)
																		.addComponent(lblAltaDeMedio))
																.addGroup(
																		groupLayout.createSequentialGroup().addGap(73)
																				.addGroup(
																						groupLayout
																								.createParallelGroup(
																										Alignment.LEADING)
																								.addComponent(lblTipo)
																								.addComponent(lblCampo)
																								.addComponent(
																										lblCampo_1)
																		.addComponent(lblCampo_2))
												.addGap(74)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 140,
																Short.MAX_VALUE)
														.addComponent(textField, 140, 140, Short.MAX_VALUE)
														.addComponent(comboBox, 0, 140, Short.MAX_VALUE)
														.addComponent(textField_1, 140, 140, Short.MAX_VALUE))))
								.addGap(129))
						.addGroup(groupLayout.createSequentialGroup().addComponent(btnOk)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnCancel).addGap(81)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap().addComponent(lblAltaDeMedio).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblTipo).addComponent(
						comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(38)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCampo).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCampo_1).addComponent(
						textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCampo_2).addComponent(
						textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnOk).addComponent(btnCancel))
				.addContainerGap()));
		getContentPane().setLayout(groupLayout);

	}
}
