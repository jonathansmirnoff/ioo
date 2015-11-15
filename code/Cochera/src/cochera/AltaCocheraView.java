package cochera;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;

public class AltaCocheraView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private SistemaAdministracionCochera sistema;

	public AltaCocheraView(SistemaAdministracionCochera sist) {
		setVisible(true);
		sistema = sist;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblCrearCocheras = new JLabel("Crear cocheras");
		lblCrearCocheras.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblCocheraID = new JLabel("ID de cochera");

		JLabel lblTamano = new JLabel("Tama\u00F1o");

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Peque\u00F1o", "Mediano", "Grande" }));

		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(83)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblTamano)
										.addComponent(lblCocheraID))
								.addGap(97)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField)))
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(151).addComponent(lblCrearCocheras)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblCrearCocheras)
						.addGap(39)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblCocheraID)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblTamano).addComponent(
						comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(84, Short.MAX_VALUE)));
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

						sistema.altaCochera(textField.getText(), comboBox.getSelectedItem().toString());
						Cochera_menu chmen = new Cochera_menu(sistema);
						dispose();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Principal prin = new Principal(sistema);
						dispose();
					}
				});
			}
		}
	}
}
