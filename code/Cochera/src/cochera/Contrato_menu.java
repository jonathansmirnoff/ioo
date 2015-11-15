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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contrato_menu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SistemaAdministracionCochera sistema;

	public Contrato_menu(SistemaAdministracionCochera sist) {
		sistema = sist;
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblContratos = new JLabel("Contratos");
		lblContratos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JButton btnAltaDeContrato = new JButton("Alta de contrato");
		btnAltaDeContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaContratoView acon = new AltaContratoView(sistema);
				dispose();
			}
		});
		JButton btnBajaDeContrato = new JButton("Baja de contrato");
		btnBajaDeContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaContratoView bjcon = new BajaContratoView(sistema);
				dispose();
			}
		});
		JButton btnModificarContrato = new JButton("Modificar contrato");
		btnModificarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarContratoView modifcon = new ModificarContratoView(sistema);
				dispose();
			}
		});
		JButton btnBuscarContrato = new JButton("Mostrar contratos");
		btnBuscarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarContratoView moscon = new MostrarContratoView(sistema);
				dispose();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(161).addComponent(lblContratos))
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(137)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnModificarContrato, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBajaDeContrato, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnAltaDeContrato, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addComponent(btnBuscarContrato, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap(142, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblContratos)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnAltaDeContrato)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnBajaDeContrato)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnModificarContrato)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnBuscarContrato)
						.addContainerGap(39, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Volver");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
