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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cliente_menu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SistemaAdministracionCochera sistema;

	public Cliente_menu(SistemaAdministracionCochera sist) {
		sistema = sist;
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnAltaDeCliente = new JButton("Alta de cliente");
		btnAltaDeCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaClienteView acl = new AltaClienteView(sist);
				dispose();
			}
		});

		JButton btnBajaDeCliente = new JButton("Baja de cliente");
		btnBajaDeCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaClienteView bcl = new BajaClienteView(sistema);
				dispose();
			}
		});

		JButton btnModificarCliente = new JButton("Modificar cliente");
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarClienteView mcl = new ModificarClienteView(sistema);
				dispose();
			}
		});

		JButton btnMostrarClientes = new JButton("Mostrar clientes");
		btnMostrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarClienteView moscl = new MostrarClienteView(sistema);
				dispose();
			}
		});

		JButton btnAsignarVehiculo = new JButton("Asignar vehiculo");
		btnAsignarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsignarAutoView auto = new AsignarAutoView(sistema);
				dispose();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(170).addComponent(lblClientes))
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(143)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnAltaDeCliente, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnModificarCliente, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBajaDeCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addComponent(btnAsignarVehiculo)
								.addComponent(btnMostrarClientes))))
						.addContainerGap(154, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblClientes).addGap(18)
						.addComponent(btnAltaDeCliente).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnBajaDeCliente).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnModificarCliente).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAsignarVehiculo).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnMostrarClientes).addContainerGap(15, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton VolverButton = new JButton("Volver");
				VolverButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Principal prin = new Principal(sistema);
						dispose();
					}
				});
				VolverButton.setActionCommand("Cancel");
				buttonPane.add(VolverButton);
			}
		}
	}
}
