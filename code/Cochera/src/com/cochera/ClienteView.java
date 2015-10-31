package com.cochera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ClienteView extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 6312746376645218785L;
	private SistemaAdministracionCochera sisAdministracionCochera;
	private boolean seEstaCreando;
	
	public ClienteView(SistemaAdministracionCochera sistema, boolean seEstaCreando){
		sisAdministracionCochera = sistema;
		setSeEstaCreando(seEstaCreando);
		initGUI();		
	}
	
	private void initGUI() {
		try {
			
			//Init
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);	        
	        
	        String operacionText = "Alta Cliente";
			if (!getSeEstaCreando()){
				operacionText = "Modificar Cliente";
			}
			
			setTitle(operacionText);
	        
			
			JLabel lblDniCliente = new JLabel("DNI Cliente: ");
			lblDniCliente.setBounds(21, 42, 103, 28);	
			getContentPane().add(lblDniCliente);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(21, 91, 103, 28);		
			getContentPane().add(lblNombre);
			
			JLabel lblDomicilio = new JLabel("Domicilio:");
			lblDomicilio.setBounds(21, 140, 103, 28);		
			getContentPane().add(lblDomicilio);
			
			JLabel lblMail = new JLabel("E-mail:");
			lblMail.setBounds(21, 189, 103, 28);		
			getContentPane().add(lblMail);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(21, 238, 103, 28);		
			getContentPane().add(lblTelefono);
			
			JTextField txtDniCliente = new JTextField();
			txtDniCliente.setBounds(139, 42, 210, 28);
			getContentPane().add(txtDniCliente);			
			
			JTextField txtNombre = new JTextField();
			txtNombre.setBounds(139, 91, 210, 28);
			getContentPane().add(txtNombre);
			
			JTextField txtDomicilio= new JTextField();			
			txtDomicilio.setBounds(139, 140, 210, 28);
			getContentPane().add(txtDomicilio);
			
			JTextField txtMail= new JTextField();			
			txtMail.setBounds(139, 189, 210, 28);
			getContentPane().add(txtMail);
			
			JTextField txtTelefono = new JTextField();
			txtTelefono.setBounds(139, 238, 210, 28);		
			getContentPane().add(txtTelefono);									
				
			JButton btnAlta = new JButton(operacionText);			
			btnAlta.setBounds(158, 297, 130, 28);
			btnAlta.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent arg0) {										
					if (getSeEstaCreando()){
						sisAdministracionCochera.crearCliente(txtDniCliente.getText(),
								txtNombre.getText(), 
								txtMail.getText(),
								txtDomicilio.getText(), 
								txtTelefono.getText());
						
						JOptionPane.showMessageDialog(null, "El cliente fue dado de alta.");
					}
					else{
						sisAdministracionCochera.modificarCliente(txtDniCliente.getText(),
								txtNombre.getText(), 
								txtMail.getText(),
								txtDomicilio.getText(), 
								txtTelefono.getText());
						
						JOptionPane.showMessageDialog(null, "El cliente fue modificado.");
					}
					
					txtDniCliente.setText("");
					txtNombre.setText("");
					txtDomicilio.setText("");
					txtMail.setText("");
					txtTelefono.setText("");					
				}
			});
			
			getContentPane().add(btnAlta);
			
			pack();
			setSize(400, 400);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean getSeEstaCreando() {
		return seEstaCreando;
	}

	public void setSeEstaCreando(boolean seEstaCreando) {
		this.seEstaCreando = seEstaCreando;
	}
}
