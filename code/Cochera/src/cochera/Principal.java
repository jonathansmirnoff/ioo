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
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		} else {
			sisCocheras = new SistemaAdministracionCochera(); // Primera vez
																// crea el
																// objeto
			this.crearSetDeDatosDePrueba(sisCocheras);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 333);

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

		JButton btnGenerarCuotas = new JButton("Generar cuotas");
		btnGenerarCuotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisCocheras.generarCuotas();
			}
		});
		btnGenerarCuotas.setForeground(Color.RED);
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
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnGenerarCuotas,
												Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))))
						.addContainerGap(65, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblSistemaDeAdministracin)
						.addGap(29).addComponent(btnCocheraMenu).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAbonos).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnClientes)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnContratos)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnMediosDePago)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnGenerarCuotas)
						.addContainerGap(37, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}
	
	private void crearSetDeDatosDePrueba(SistemaAdministracionCochera sis){
		//Creo medio de pago
		sis.altaMedioDePago("VISA", "Banco Galicia");
		sis.altaMedioDePago("AMEX", "Banco HSBC");
		sis.altaMedioDePago("MASTER", "Banco Rio");
		
		//Creo cocheras
		sis.altaCochera("1", "Pequeño");
		sis.altaCochera("2", "Mediaño");
		sis.altaCochera("3", "Grande");
		
		//Creo Abonos
		sis.altaAbono("Pequeño", 50, "Quincenal");
		sis.altaAbono("Mediano", 100, "Mensual");
		sis.altaAbono("Mediano", 200, "Semestral");
		
		//Alta Clientes:
		sis.crearCliente("10111203", "Pedro Garcia", "pedrogarcia@gmail.com", "Juan B Justo 1042", "4855-8872");
		sis.crearCliente("30111203", "Guido Brener", "guidobrener@gmail.com", "Luis María 100", "4845-8872");
		sis.crearCliente("40111203", "Alex Perez", "alexperez@gmail.com", "Cordoba 2000", "15-6855-8872");
		
		//Asignar auto
		sis.asignarAuto("10111203", "XX2123", "Polo", "2003");
		sis.asignarAuto("30111203", "SXS400", "Ford", "2015");
		sis.asignarAuto("40111203", "ABC123", "Camaro", "2010");
		
		//Crear contratos
		sis.altaContratoEfectivo("10111203", "1", "Pequeño", "Quincenal", "XX2123");
		sis.altaContratoEfectivo("30111203", "2", "Mediano", "Mensual", "SXS400");
		sis.altaContratoCheque("40111203", "3", "Mediano", "Semestral", "ABC123");
		
		//Corro la fecha de creación para generar deuda:
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.DAY_OF_MONTH, -15);
		sis.getContratos().get(0).setFechaDeCreacion(cal.getTime());
		
		
		
	}
}
