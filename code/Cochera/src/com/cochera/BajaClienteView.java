package com.cochera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class BajaClienteView extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	private SistemaAdministracionCochera sisAdministracionCochera;	
	public BajaClienteView(SistemaAdministracionCochera sistema){
		sisAdministracionCochera = sistema;		
		initGUI();		
	}
	
	private void initGUI() {
		try {
			
			//Init
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);	       	        
			setTitle("Baja Cliente");	        
			
			JLabel lblDniCliente = new JLabel("DNI Cliente: ");
			lblDniCliente.setBounds(21, 42, 103, 28);	
			getContentPane().add(lblDniCliente);
						
			JTextField txtDniCliente = new JTextField();
			txtDniCliente.setBounds(139, 42, 210, 28);
			getContentPane().add(txtDniCliente);			
							
			JButton btnBaja = new JButton("Dar de baja.");			
			btnBaja.setBounds(158, 100, 130, 28);
			btnBaja.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent arg0) {					
						sisAdministracionCochera.bajaCliente(txtDniCliente.getText());						
						JOptionPane.showMessageDialog(null, "El cliente fue dado de baja.");
						txtDniCliente.setText("");
					}						
				});
			
			getContentPane().add(btnBaja);
			
			pack();
			setSize(400, 200);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
