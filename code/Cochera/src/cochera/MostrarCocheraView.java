package cochera;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class MostrarCocheraView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SistemaAdministracionCochera sistema;
	private JTable table;

	public MostrarCocheraView(SistemaAdministracionCochera sist) {
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
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPanel
				.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPanel.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)));
		{
			DefaultTableModel modelo = new DefaultTableModel();
			table = new JTable(modelo);
			table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID Cochera", "Tama\u00F1o" }));
			scrollPane.setViewportView(table);

			Object[] fila = new Object[2];

			Iterator<Cochera> cocheras = sistema.getCocheras().iterator();
			Cochera aux;
			while (cocheras.hasNext()) {
				aux = cocheras.next();
				fila[0] = aux.getId();
				fila[1] = aux.getTamano();

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
				VolverButton.setActionCommand("Cancel");
				buttonPane.add(VolverButton);
				VolverButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						Cochera_menu chmen = new Cochera_menu(sistema);
						dispose();

					}
				});
			}
		}

		// table.
	}
}
