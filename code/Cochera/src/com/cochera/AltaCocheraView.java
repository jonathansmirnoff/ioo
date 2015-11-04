package com.cochera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AltaCocheraView extends javax.swing.JFrame {
	
	private static final long serialVersionUID = -6175318392858973945L;
	private SistemaAdministracionCochera sisAdministracionCochera;
	
	public AltaCocheraView(SistemaAdministracionCochera sistema){
		initGUI();
		sisAdministracionCochera = sistema;
	}
	
	private void initGUI() {
		try {
			
			//Init
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Alta cochera");
	        setSize(300, 200);
	        setLocationRelativeTo(null);
			
			JLabel lblCodigoCochera = new JLabel("Codigo Cochera: ");
			lblCodigoCochera.setBounds(21, 42, 103, 28);	
			getContentPane().add(lblCodigoCochera);
			
			JLabel lblTamano = new JLabel("Tamaño:");
			lblTamano.setBounds(21, 91, 103, 28);		
			getContentPane().add(lblTamano);
			
			JTextField txtCodigoCochera = new JTextField();
			txtCodigoCochera.setBounds(139, 42, 210, 28);
			getContentPane().add(txtCodigoCochera);			
			
			JTextField txtTamano = new JTextField();			
			txtTamano.setBounds(139, 91, 210, 28);
			getContentPane().add(txtTamano);
			
			JButton btnAlta = new JButton("Alta Cochera");			
			btnAlta.setBounds(158, 217, 113, 28);
			btnAlta.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					sisAdministracionCochera.altaCochera(txtCodigoCochera.getText(), txtTamano.getText());										
					
					//TODO: Agregar popUp para avisar que la cochera fue dada de alta.
					JOptionPane.showMessageDialog(null, "La cochera fue dada de alta.");
					
					txtCodigoCochera.setText("");
					txtTamano.setText("");					
				}
			});
			getContentPane().add(btnAlta);
			
			pack();
			setSize(400, 300);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
