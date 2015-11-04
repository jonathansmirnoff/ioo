package com.cochera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AsignarAutoView extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	private SistemaAdministracionCochera sisAdministracionCochera;
	
	public SistemaAdministracionCochera getSisAdministracionCochera() {
		return sisAdministracionCochera;
	}
	public void setSisAdministracionCochera(SistemaAdministracionCochera sisAdministracionCochera) {
		this.sisAdministracionCochera = sisAdministracionCochera;
	}
	
	public AsignarAutoView(SistemaAdministracionCochera sistema){
		initGUI();
		sisAdministracionCochera = sistema;
	}
	
	private void initGUI() {
		try {
			//Init
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			setTitle("Asignar Auto");
	        			
			JLabel lblDniCliente = new JLabel("DNI Cliente: ");
			lblDniCliente.setBounds(21, 42, 103, 28);	
			getContentPane().add(lblDniCliente);
			
			JLabel lblPatente = new JLabel("Patente:");
			lblPatente.setBounds(21, 91, 103, 28);		
			getContentPane().add(lblPatente);
			
			JLabel lblMarca = new JLabel("Marca:");
			lblMarca.setBounds(21, 140, 103, 28);		
			getContentPane().add(lblMarca);
			
			JLabel lblModelo = new JLabel("Modelo:");
			lblModelo.setBounds(21, 189, 103, 28);		
			getContentPane().add(lblModelo);
			
			JTextField txtDniCliente = new JTextField();
			txtDniCliente.setBounds(139, 42, 210, 28);
			getContentPane().add(txtDniCliente);			
			
			JTextField txtPatente = new JTextField();
			txtPatente.setBounds(139, 91, 210, 28);
			getContentPane().add(txtPatente);
			
			JTextField txtMarca = new JTextField();			
			txtMarca.setBounds(139, 189, 210, 28);
			getContentPane().add(txtMarca);
			
			JTextField txtModelo = new JTextField();			
			txtModelo.setBounds(139, 140, 210, 28);
			getContentPane().add(txtModelo);
			
			
			JButton btnAsignar = new JButton("Asignar Auto");			
			btnAsignar.setBounds(158, 297, 130, 28);
			btnAsignar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					//TODO: Validaciones. Que cada campo sea obligatorio.					
					getSisAdministracionCochera().asignarAuto(txtDniCliente.getText(), txtPatente.getText(), txtMarca.getText(), txtModelo.getText());
				}
			});
			getContentPane().add(btnAsignar);
			
			pack();
			setSize(400, 400);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
