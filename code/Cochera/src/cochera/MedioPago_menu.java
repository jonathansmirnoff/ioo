package cochera;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MedioPago_menu extends JDialog {

	private SistemaAdministracionCochera sistema;

	public MedioPago_menu(SistemaAdministracionCochera sist) {
		setVisible(true);
		sistema = sist;
		setBounds(100, 100, 450, 300);

		JLabel lblMediosDePago = new JLabel("Medios de pago");
		lblMediosDePago.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnAltaDePago = new JButton("Alta de pago");
		btnAltaDePago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaPagoView ap = new AltaPagoView(sistema);
				dispose();

			}
		});

		JButton btnBajaDePago = new JButton("Baja de pago");
		btnBajaDePago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaPagoView bpago = new BajaPagoView(sistema);
				dispose();
			}
		});

		JButton btnMostrarPagos = new JButton("Mostrar pagos");
		btnMostrarPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarPagoView mpago = new MostrarPagoView(sistema);
				dispose();
			}
		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal pr = new Principal(sistema);
				dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(323, Short.MAX_VALUE)
								.addComponent(btnVolver).addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addGap(145)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnAltaDePago, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMediosDePago, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBajaDePago, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnMostrarPagos,
										Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap(162, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblMediosDePago).addGap(35)
						.addComponent(btnAltaDePago).addGap(18).addComponent(btnBajaDePago).addGap(18)
						.addComponent(btnMostrarPagos).addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
						.addComponent(btnVolver).addContainerGap()));
		getContentPane().setLayout(groupLayout);

	}
}
