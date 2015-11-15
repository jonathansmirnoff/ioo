package cochera;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class MostrarPagoView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SistemaAdministracionCochera sistema;
	private JTable table;

	public MostrarPagoView(SistemaAdministracionCochera sist) {
		sistema = sist;
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPanel
				.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPanel.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)));

		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Tipo", "Entidad" }));
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);

		Object[] fila = new Object[2];

		Iterator<MedioDePago> pagos = sistema.getMediosDePago().iterator();
		MedioDePago aux;
		while (pagos.hasNext()) {
			aux = pagos.next();
			if (aux.getEstado() == 1) {
				fila[0] = aux.getTipo();
				fila[1] = aux.getEntidad();

				((DefaultTableModel) table.getModel()).addRow(fila);
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
						MedioPago_menu mpmen = new MedioPago_menu(sistema);
						dispose();
					}
				});
				VolverButton.setActionCommand("Cancel");
				buttonPane.add(VolverButton);
			}
		}
	}
}
