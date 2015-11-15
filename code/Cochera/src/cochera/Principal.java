package cochera;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;*/
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SistemaAdministracionCochera sisCocheras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal(SistemaAdministracionCochera sist) {

		if (sist != null) {
			this.setVisible(true);
			sisCocheras = sist; // Vuelve desde otra pantalla
		} else
			sisCocheras = new SistemaAdministracionCochera(); // Primera vez
																// crea el
																// objeto
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JButton btnCocheraMenu = new JButton("Cocheras");
		btnCocheraMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cochera_menu chmen = new Cochera_menu(sisCocheras);
				dispose();
			}
		});

		JButton btnAbonos = new JButton("Abonos");
		btnAbonos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Abono_menu ab = new Abono_menu(sisCocheras);
				dispose();

			}
		});

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente_menu clmen = new Cliente_menu(sisCocheras);
				dispose();
			}
		});

		JButton btnContratos = new JButton("Contratos");
		btnContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contrato_menu conmen = new Contrato_menu(sisCocheras);
				dispose();
			}
		});

		JButton btnMediosDePago = new JButton("Medios de pago");
		btnMediosDePago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedioPago_menu mpmen = new MedioPago_menu(sisCocheras);
				dispose();
			}
		});

		JLabel lblSistemaDeAdministracin = new JLabel("Sistema de administracion de cocheras");
		lblSistemaDeAdministracin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSistemaDeAdministracin.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(63)
										.addComponent(lblSistemaDeAdministracin))
						.addGroup(groupLayout.createSequentialGroup().addGap(138)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnContratos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnClientes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAbonos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnCocheraMenu, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
								.addComponent(btnMediosDePago, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addContainerGap(65, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblSistemaDeAdministracin)
						.addGap(29).addComponent(btnCocheraMenu).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAbonos).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnClientes)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnContratos)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnMediosDePago)
						.addContainerGap(36, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

}
