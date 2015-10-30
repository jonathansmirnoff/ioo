package com.cochera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MapaCocheraView extends javax.swing.JFrame {
	
	private static final long serialVersionUID = -4955968751913711979L;
	private SistemaAdministracionCochera sistemaAdministracionCochera;
	
	public MapaCocheraView(SistemaAdministracionCochera sis) {
		setSistemaAdministracionCochera(sis);
		initGUI();
	}	
	
	private void initGUI() {
		try {
			//TODO: Add header to the table!
			
			//Init
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			//Columnas de la tabla
			Vector columnas = new Vector();
			columnas.add("Codigo");
			columnas.add("Tamano");
			columnas.add("Estado");
			
			Vector<Vector<String>> datos = new Vector<Vector<String>>();
			Iterator<Cochera> it = getSistemaAdministracionCochera().getCocheras().iterator();
			while(it.hasNext()){
				Cochera cochera = it.next();
				
				Vector<String> cocheraToShow = new Vector<String>();
				cocheraToShow.addElement(cochera.getId());
				cocheraToShow.addElement(cochera.getTamano());
				cocheraToShow.addElement(String.valueOf(cochera.getEstado()));
				
				datos.addElement(cocheraToShow);
			}
			
			TableModel mapaDeCocherasModel = new DefaultTableModel(datos, columnas);
			JTable tblMapaCocheras = new JTable();			
			tblMapaCocheras.setModel(mapaDeCocherasModel);
			tblMapaCocheras.setBounds(14, 14, 350, 189);
			tblMapaCocheras.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tblMapaCocheras.setLocation(new java.awt.Point(0, -1));
			getContentPane().add(tblMapaCocheras);
			
			//Refresh
			pack();
			this.setSize(400, 328);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SistemaAdministracionCochera getSistemaAdministracionCochera() {
		return sistemaAdministracionCochera;
	}

	public void setSistemaAdministracionCochera(SistemaAdministracionCochera sistemaAdministracionCochera) {
		this.sistemaAdministracionCochera = sistemaAdministracionCochera;
	}
	

}
