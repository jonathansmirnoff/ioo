package cochera;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;

public class MostrarAbonoView extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private SistemaAdministracionCochera sistema;
	private JTable table;

	public MostrarAbonoView(SistemaAdministracionCochera sist) {
		this.setVisible(true);
		sistema = sist;
		setBounds(100, 100, 522, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(contentPanel);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
								.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		DefaultTableModel modelo = new DefaultTableModel();

		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Periodo", "Tamano", "Precio" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(99);

		Object[] fila = new Object[3];

		Iterator<Abono> abonos = sistema.getAbonos().iterator();
		Abono aux;
		while (abonos.hasNext()) {
			aux = abonos.next();
			if (aux.getEstado() == 1) {				
				fila[0] = aux.getPeriodo();
				fila[1] = aux.getTamano();
				fila[2] = aux.getPrecio();

				((DefaultTableModel) table.getModel()).addRow(fila);
			}

		}

		scrollPane.setViewportView(table);
		contentPanel.setLayout(groupLayout);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton VolverButton = new JButton("Volver");
				VolverButton.setActionCommand("Cancel");
				buttonPane.add(VolverButton);
				VolverButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Abono_menu abmen = new Abono_menu(sistema);
						dispose();
					}
				});
			}
		}
	}
}
