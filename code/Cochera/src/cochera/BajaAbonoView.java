package cochera;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import java.awt.Font;

public class BajaAbonoView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SistemaAdministracionCochera sistema;

	public BajaAbonoView(SistemaAdministracionCochera sist) {
		setVisible(true);
		sistema = sist;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNewLabel = new JLabel("Tama\u00F1o");
		JLabel lblNewLabel_2 = new JLabel("Periodo");
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();

		JLabel lblBajaDeAbonos = new JLabel("Baja de Abonos");
		lblBajaDeAbonos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(147).addComponent(lblBajaDeAbonos)
						.addContainerGap(81, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
						.addContainerGap(85, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel))
						.addGap(103)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGap(81)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblBajaDeAbonos)
						.addGap(38)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addContainerGap(79, Short.MAX_VALUE)));
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

						sistema.bajaAbono(comboBox.getSelectedItem().toString(),
								comboBox_1.getSelectedItem().toString());
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

		comboBox.addItem("Pequeño");
		comboBox.addItem("Mediano");
		comboBox.addItem("Grande");

		comboBox_1.addItem("Quincenal");
		comboBox_1.addItem("Mensual");
		comboBox_1.addItem("Semestral");
		comboBox_1.addItem("Anual");
	}
}
