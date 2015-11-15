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
import java.awt.event.ActionEvent;

public class BajaPagoView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SistemaAdministracionCochera sistema;
	private JTextField textField;

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

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setVisible(false);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().toString().compareTo("Debito CBU") != 0
						&& comboBox.getSelectedItem().toString().compareTo("Tarjeta de credito") != 0) {
					lblCampo.setVisible(false);
					textField.setVisible(false);
				}

				if (comboBox.getSelectedItem().toString().compareTo("Debito CBU") == 0) {
					lblCampo.setText("Entidad emisora:");
					lblCampo.setVisible(true);
					textField.setVisible(true);

				}
				if (comboBox.getSelectedItem().toString().compareTo("Tarjeta de credito") == 0) {
					lblCampo.setText("Entidad bancaria:");
					lblCampo.setVisible(true);
					textField.setVisible(true);

				}
			}
		});
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Efectivo", "Cheque", "Tarjeta de credito", "Debito CBU" }));

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(118).addComponent(lblBajaDeMedio)
						.addContainerGap(113, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
						.addContainerGap(98, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblTipo)
								.addComponent(lblCampo))
						.addGap(74)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false).addComponent(textField)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
						.addGap(70)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addContainerGap().addComponent(lblBajaDeMedio).addGap(29)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblTipo).addComponent(
						comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblCampo).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						sistema.bajaMedioDePago(comboBox.getSelectedItem().toString(), textField.getText());
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
	}
}
