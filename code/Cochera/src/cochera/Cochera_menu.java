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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cochera_menu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SistemaAdministracionCochera sistema;

	public Cochera_menu(SistemaAdministracionCochera sist) {
		setVisible(true);
		sistema = sist;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCocheras = new JLabel("Cocheras");
		lblCocheras.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCrearCochera = new JButton("Crear cochera");
		btnCrearCochera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaCocheraView ach = new AltaCocheraView(sistema);
				dispose();
			}
		});

		JButton btnMostrarCocheras = new JButton("Mostrar cocheras");
		btnMostrarCocheras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarCocheraView mostrar = new MostrarCocheraView(sistema);
				dispose();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(165).addComponent(lblCocheras)
								.addGap(137))
				.addGroup(Alignment.TRAILING,
						gl_contentPanel.createSequentialGroup().addGap(134)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnCrearCochera, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144,
												Short.MAX_VALUE)
										.addComponent(btnMostrarCocheras, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												137, Short.MAX_VALUE))
								.addGap(144)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblCocheras).addGap(39)
						.addComponent(btnCrearCochera).addGap(18).addComponent(btnMostrarCocheras)
						.addContainerGap(66, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Volver");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Principal prin = new Principal(sistema);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
