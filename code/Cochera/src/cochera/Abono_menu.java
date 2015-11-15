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
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Abono_menu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private SistemaAdministracionCochera sistema;

	public Abono_menu(SistemaAdministracionCochera sist) {
		this.setVisible(true);
		sistema = sist;

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		JLabel lblAbonos = new JLabel("Abonos");
		lblAbonos.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnAltaDeAbono = new JButton("Alta de abono");
		btnAltaDeAbono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaAbonoView abovista = new AltaAbonoView(sistema);
				dispose();
			}
		});

		JButton btnBajaAbono = new JButton("Baja de abono");
		btnBajaAbono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BajaAbonoView abovista = new BajaAbonoView(sistema);
				dispose();
			}
		});

		JButton btnModifAbono = new JButton("Modificacion de Abono");
		btnModifAbono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarAbonoView abovista = new ModificarAbonoView(sistema);
				dispose();
			}
		});

		JButton btnMostrarAbonos = new JButton("Mostrar abonos");
		btnMostrarAbonos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarAbonoView mabo = new MostrarAbonoView(sistema);
				dispose();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(164).addComponent(lblAbonos)
						.addContainerGap(199, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(58).addGroup(gl_contentPanel
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAltaDeAbono, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
						.addComponent(btnBajaAbono, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
						.addComponent(btnModifAbono, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
						.addComponent(btnMostrarAbonos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 292,
								Short.MAX_VALUE))
						.addGap(72)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblAbonos).addGap(25)
						.addComponent(btnAltaDeAbono).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnBajaAbono).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnModifAbono).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnMostrarAbonos).addContainerGap(27, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Volver");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Principal pr = new Principal(sistema);
						dispose();
					}
				});
			}
		}

	}
}
