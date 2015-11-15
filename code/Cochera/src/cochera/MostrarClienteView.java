package cochera;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MostrarClienteView extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private SistemaAdministracionCochera sistema;
	private JTable table;

	public MostrarClienteView(SistemaAdministracionCochera sist) {
		sistema = sist;
		setVisible(true);
		setBounds(100, 100, 756, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
								.addContainerGap()));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		{
			DefaultTableModel modelo = new DefaultTableModel();
			table = new JTable(modelo);
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "DNI", "Nombre", "Domicilio", "E-Mail", "Telefono" }));
			scrollPane.setViewportView(table);

			Object[] fila = new Object[5];

			Iterator<Cliente> clientes = sistema.getClientes().iterator();
			Cliente aux;
			while (clientes.hasNext()) {
				aux = clientes.next();
				if (aux.getEstaActivo()) {
					fila[0] = aux.getDni();
					fila[1] = aux.getNombre();
					fila[2] = aux.getDomicilio();
					fila[3] = aux.getMail();
					fila[4] = aux.getTelefono();

					((DefaultTableModel) table.getModel()).addRow(fila);
				}

			}
		}
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton VolverButton = new JButton("Volver");
				VolverButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cliente_menu clmenu = new Cliente_menu(sistema);
						dispose();
					}
				});
				VolverButton.setActionCommand("Cancel");
				buttonPane.add(VolverButton);
			}
		}
	}

}
