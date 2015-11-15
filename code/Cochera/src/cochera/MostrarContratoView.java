package cochera;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MostrarContratoView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SistemaAdministracionCochera sistema;
	private JTable table;

	public MostrarContratoView(SistemaAdministracionCochera sist) {
		sistema = sist;
		setVisible(true);
		setBounds(100, 100, 889, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
								.addContainerGap()));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		{
			DefaultTableModel modelo = new DefaultTableModel();
			table = new JTable(modelo);
			table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nro contrato", "Periodo",
					"Tama\u00F1o", "Precio", "DNI", "Nombre", "Domicilio", "E-mail", "Telefono", "ID cochera" }));
			scrollPane.setViewportView(table);

			Object[] fila = new Object[10];

			Iterator<Contrato> contratos = sistema.getContratos().iterator();
			Contrato aux;
			while (contratos.hasNext()) {
				aux = contratos.next();
				if (aux.getEstaActivo()) {
					fila[0] = aux.getNroContrato();
					fila[1] = aux.getAbono().getPeriodo();
					fila[2] = aux.getAbono().getPrecio();
					fila[3] = aux.getAbono().getPrecio();
					fila[4] = aux.getCliente().getDni();
					fila[5] = aux.getCliente().getNombre();
					fila[6] = aux.getCliente().getDomicilio();
					fila[7] = aux.getCliente().getMail();
					fila[8] = aux.getCliente().getTelefono();
					fila[9] = aux.getCochera().getId();

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
						Contrato_menu conmenu = new Contrato_menu(sistema);
						dispose();
					}
				});
				VolverButton.setActionCommand("Cancel");
				buttonPane.add(VolverButton);
			}
		}
	}

}
