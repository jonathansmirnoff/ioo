package com.cochera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class MainCochera extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private SistemaAdministracionCochera sisCocheras;
	
	public MainCochera(){
		this.sisCocheras = new SistemaAdministracionCochera();
	}

	public static void main(String[] args) {
		MainCochera main = new MainCochera();
		//main.mostrarMenu();
		main.setVisible(true);
		main.initGUI();
	}
	
	private void initGUI() {		
		try {
			
	        setTitle("Sistema Administracion Cochera");
	        setSize(300, 200);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			//Creo la barra de menu!
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			menuBar.setPreferredSize(new java.awt.Dimension(392, 22));
			
			menuBar.add(getMenuCochera());
			menuBar.add(getMenuSalir());	
					
			pack();		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JMenu getMenuCochera(){
		
		//Creo un menu!
		JMenu menuCocheras = new JMenu();
		menuCocheras.setText("Cocheras");
		menuCocheras.setPreferredSize(new java.awt.Dimension(65, 21));
		
		JMenuItem mapaCocherasMenuItem = new JMenuItem();
		mapaCocherasMenuItem.setText("Mapa de Cocheras");
		mapaCocherasMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MapaCocheraView mapaCocheraView = new MapaCocheraView(sisCocheras);
				mapaCocheraView.setVisible(true);				
			}
		});
		
		menuCocheras.add(mapaCocherasMenuItem);
		
		JMenuItem altaCocheraMenuItem = new JMenuItem();
		altaCocheraMenuItem.setText("Alta Cochera");
		altaCocheraMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				AltaCocheraView altaCocheraView = new AltaCocheraView(sisCocheras);
				altaCocheraView.setVisible(true);
			}
		});
		
		menuCocheras.add(altaCocheraMenuItem);
		
		return menuCocheras;		
	}
	
	private JMenu getMenuSalir(){
		//Creo un menu!
		JMenu menuSalir = new JMenu();
		menuSalir.setText("Salir");
		menuSalir.setPreferredSize(new java.awt.Dimension(40, 21));
		
		//Agrego un listener al menu!
		menuSalir.addMenuListener(new MenuListener() {				
			@Override
			public void menuSelected(MenuEvent e) {				
				System.exit(NORMAL);
			}

			@Override
			public void menuCanceled(MenuEvent e) {				
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				
			}				
		});
		
		return menuSalir;
	}
	
	
	public void mostrarMenu(){
		System.out.println();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("MENU DE OPCIONES");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Crear Cliente");
		System.out.println("2.- Eliminar Cliente");
		System.out.println("3.- Modificar Cliente");
		System.out.println("4.- Asignar Auto");
		System.out.println("5.- Alta Cochera");
		System.out.println("6.- Mapa de Cocheras");
		System.out.println("7.- Alta Medio de Pago");
		System.out.println("8.- Baja Medio de Pago");
		System.out.println("9.- Crear Abono");
		System.out.println("10.- Eliminar Abono");
		System.out.println("11.- Modificar Abono");
		System.out.println("12.- Crear Contrato");
		System.out.println("13.- Eliminar Contrato");
		System.out.println("14.- Modificar Contrato");
		System.out.println("0.- Salir");
		System.out.println("-------------------------------------------------------");
		System.out.print("Opcion:");
		try
		{
			String s = (String)reader.readLine();
			
		  	switch (Integer.parseInt(s))
		  	{		  	
		  		case 1 : {
		  			this.crearCliente();
		  			break;
		  		}		  		
			  	case 2 : {
			  		this.modificarCliente();
			  		break;
			  	}
			  	case 4 : {
			  		this.asignarAuto();
			  		break;
			  	}
			  	case 5 : {
			  		this.altaCochera();
			  		break;
			  	}
			  	case 6 : {
			  		this.mapaDeCocheras();
			  		break;
			  	}
			  	case 7 : {
			  		this.altaMedioDePago();
			  		break;
			  	}
			  	case 8 : {
			  		this.bajaMedioDePago();
			  		break;
			  	}
			  	case 9 : {
			  		this.crearAbono();
			  		break;
			  	}
			  	case 10 : {
			  		this.bajaAbono();
			  		break;
			  	}
			  	case 11 : {
			  		this.modificarAbono();
			  		break;
			  	}
			  	case 12 : {
			  		this.crearContrato();
			  		break;
			  	}
			  	case 13 : {
			  		this.modificarContrato();
			  		break;
			  	}
			  	case 14 : {
			  		this.bajaContrato();
			  		break;
			  	}
			  	case 0 : {
			  		this.salir();
			  	}
		  	}
		}
		catch (Exception e)
		{
		}

	}
	
	private void bajaContrato() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("DAR DE BAJA CONTRATO");
			System.out.println("---------------");
			System.out.print("Ingrese ID de contrato:");			
			String idContrato = reader.readLine();				
			
			this.sisCocheras.bajaContrato(Integer.parseInt(idContrato));
			
			System.out.print("El contrato ha sido creado.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}

	private void modificarContrato() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("----------------------------------------");
			System.out.println("MODIFICAR CONTRATO");
			System.out.println("SELECCIONE EL TIPO DE CONTRATO A MODIFICAR");
			System.out.println("1. - Efectivo");
			System.out.println("2. - Cheque");
			System.out.println("3. - Debito tarjeta de credito");
			System.out.println("4. - Debito CBU");
			System.out.println("0. - Volver al menu anterior");
			System.out.println("----------------------------------------");
			System.out.print("Opcion:");
						
			String s = (String)reader.readLine();
			switch (Integer.parseInt(s))
		  	{
			  	case 1 : {
		  			this.modificarContratoEfectivo();
		  			break;
		  		}
			  	case 2 : {
		  			this.modificarContratoCheque();
		  			break;
		  		}
			  	case 3 : {
		  			this.modificarContratoDebitoTarjetaDeCredito();
		  			break;
		  		}
		  		case 4 : {
		  			this.modificarContratoDebitoCBU();
		  			break;
		  		}
		  		case 0 : {
			  		this.mostrarMenu();
			  	}
		  	}
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}

	private void crearContrato() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("----------------------------------------");
			System.out.println("ALTA DE CONTRATO");
			System.out.println("SELECCIONE EL TIPO DE CONTRATO A CREAR");
			System.out.println("1. - Efectivo");
			System.out.println("2. - Cheque");
			System.out.println("3. - Debito tarjeta de credito");
			System.out.println("4. - Debito CBU");
			System.out.println("0. - Volver al menu anterior");
			System.out.println("----------------------------------------");
			System.out.print("Opcion:");
						
			String s = (String)reader.readLine();
			switch (Integer.parseInt(s)){
				case 1: {
					this.crearContratoEfectivo();
					break;
				}
				case 2: {
					this.crearContratoCheque();
					break;
				}
				case 3: {
					this.crearContratoTarjetaCredito();
					break;
				}
		  		case 4 : {
		  			this.crearContratoDebitoCBU();
		  			break;
		  		}
		  		case 0 : {
			  		this.mostrarMenu();
			  	}
		  	}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private void crearContratoDebitoCBU() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("ALTA CONTRATO DEBITO CBU");
			System.out.println("---------------");
			System.out.print("Ingrese dni cliente:");
			String dniCliente = reader.readLine();
			System.out.print("Ingrese id cochera:");
			String idCochera = reader.readLine();
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();
			System.out.print("Ingrese periodo:");
			String periodo = reader.readLine();
			System.out.print("Ingrese entidad:");
			String entidad = reader.readLine();
			System.out.print("Ingrese CBU:");
			String cbu = reader.readLine();
			System.out.print("Ingrese patente:");
			String patente = reader.readLine();						
			
			this.sisCocheras.altaContratoDebitoCBU(dniCliente, idCochera, tamano, periodo, entidad, cbu, patente);
			
			System.out.print("El contrato ha sido creado.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private void crearContratoEfectivo() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("ALTA CONTRATO EFECTIVO");
			System.out.println("---------------");
			System.out.print("Ingrese dni cliente:");
			String dniCliente = reader.readLine();
			System.out.print("Ingrese id cochera:");
			String idCochera = reader.readLine();
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();
			System.out.print("Ingrese periodo:");
			String periodo = reader.readLine();
			System.out.print("Ingrese patente:");
			String patente = reader.readLine();		
			
			this.sisCocheras.altaContratoEfectivo(dniCliente, idCochera, tamano, periodo, patente);
			
			System.out.print("El contrato ha sido creado.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private void crearContratoCheque() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("ALTA CONTRATO CHEQUE");
			System.out.println("---------------");
			System.out.print("Ingrese dni cliente:");
			String dniCliente = reader.readLine();
			System.out.print("Ingrese id cochera:");
			String idCochera = reader.readLine();
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();
			System.out.print("Ingrese periodo:");
			String periodo = reader.readLine();
			System.out.print("Ingrese patente:");
			String patente = reader.readLine();		
			
			this.sisCocheras.altaContratoCheque(dniCliente, idCochera, tamano, periodo, patente);
			
			System.out.print("El contrato ha sido creado.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private void crearContratoTarjetaCredito() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("ALTA CONTRATO CHEQUE");
			System.out.println("---------------");
			System.out.print("Ingrese dni cliente:");
			String dniCliente = reader.readLine();
			System.out.print("Ingrese id cochera:");
			String idCochera = reader.readLine();
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();
			System.out.print("Ingrese periodo:");
			String periodo = reader.readLine();
			System.out.print("Ingrese entidad:");
			String entidad = reader.readLine();
			System.out.print("Ingrese patente:");
			String patente = reader.readLine();
			System.out.print("Ingrese numero:");
			String numero = reader.readLine();
			System.out.print("Ingrese fecha de vencimiento:");
			String fechaDeVencimiento = reader.readLine();
			
			DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
			
			this.sisCocheras.altaContratoDebitoTarjetaCredito(dniCliente, idCochera, tamano, periodo, patente, entidad, numero, df.parse(fechaDeVencimiento));
			
			System.out.print("El contrato ha sido creado.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private void modificarContratoDebitoCBU() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("MODIFICAR CONTRATO DEBITO CBU");
			System.out.println("---------------");
			System.out.print("Ingrese ID de contrato:");			
			String idContrato = reader.readLine();
			System.out.print("Ingrese dni cliente:");
			String dniCliente = reader.readLine();
			System.out.print("Ingrese id cochera:");
			String idCochera = reader.readLine();
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();
			System.out.print("Ingrese periodo:");
			String periodo = reader.readLine();
			System.out.print("Ingrese entidad:");
			String entidad = reader.readLine();
			System.out.print("Ingrese CBU:");
			String cbu = reader.readLine();
			System.out.print("Ingrese patente:");
			String patente = reader.readLine();						
			
			//TODO: Implementar modificacion.
			this.sisCocheras.modificarContratoDebitoCBU(Integer.parseInt(idContrato), dniCliente, idCochera, tamano, periodo, entidad, cbu, patente);
			System.out.print("El contrato ha sido creado.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private void modificarContratoEfectivo() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("MODIFICAR CONTRATO EFECTIVO");
			System.out.println("---------------");
			System.out.print("Ingrese ID de contrato:");			
			String idContrato = reader.readLine();
			System.out.print("Ingrese dni cliente:");
			String dniCliente = reader.readLine();
			System.out.print("Ingrese id cochera:");
			String idCochera = reader.readLine();
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();
			System.out.print("Ingrese periodo:");
			String periodo = reader.readLine();
			System.out.print("Ingrese entidad:");
			String entidad = reader.readLine();
			System.out.print("Ingrese CBU:");
			
			//TODO: Implementar modificacion.
			this.sisCocheras.modificarEfectivo(Integer.parseInt(idContrato), dniCliente, idCochera, tamano, periodo, entidad);
			System.out.print("El contrato ha sido modificado.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private void modificarContratoCheque() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("MODIFICAR CONTRATO CHEQUE");
			System.out.println("---------------");
			System.out.print("Ingrese ID de contrato:");			
			String idContrato = reader.readLine();
			System.out.print("Ingrese dni cliente:");
			String dniCliente = reader.readLine();
			System.out.print("Ingrese id cochera:");
			String idCochera = reader.readLine();
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();
			System.out.print("Ingrese periodo:");
			String periodo = reader.readLine();
			System.out.print("Ingrese entidad:");
			String entidad = reader.readLine();
			System.out.print("Ingrese CBU:");
			
			this.sisCocheras.modificarCheque(Integer.parseInt(idContrato), dniCliente, idCochera, tamano, periodo, entidad);
			System.out.print("El contrato ha sido modificado.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private void modificarContratoDebitoTarjetaDeCredito() {
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("ALTA CONTRATO CHEQUE");
			System.out.println("---------------");
			System.out.print("Ingrese nro de contrato:");
			String nroContrato = reader.readLine();
			System.out.print("Ingrese dni cliente:");
			String dniCliente = reader.readLine();
			System.out.print("Ingrese id cochera:");
			String idCochera = reader.readLine();
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();
			System.out.print("Ingrese periodo:");
			String periodo = reader.readLine();
			System.out.print("Ingrese entidad:");
			String entidad = reader.readLine();
			System.out.print("Ingrese patente:");
			String patente = reader.readLine();
			System.out.print("Ingrese numero:");
			String numero = reader.readLine();
			String fechaDeVencimiento = reader.readLine();
			
			DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
			
			this.sisCocheras.modificarDebitoTarjetaCredito(Integer.parseInt(nroContrato), dniCliente, idCochera, tamano, periodo, patente, entidad, numero, df.parse(fechaDeVencimiento));
					
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}

	private void bajaMedioDePago() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("ALTA MEDIO DE PAGO");
			System.out.println("---------------");
			System.out.print("Ingrese tipo:");
			String tipo = reader.readLine();
			System.out.print("Ingrese entidad:");
			String entidad = reader.readLine();
			
			this.sisCocheras.bajaMedioDePago(tipo, entidad);
			
			System.out.print("El medio de pago fue dado de baja.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}	
	}

	private void altaMedioDePago() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("ALTA MEDIO DE PAGO");
			System.out.println("---------------");
			System.out.print("Ingrese tipo:");
			String tipo = reader.readLine();
			System.out.print("Ingrese entidad:");
			String entidad = reader.readLine();
			
			this.sisCocheras.altaMedioDePago(tipo, entidad);
			
			System.out.print("El medio de pago fue creado.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}

	private void mapaDeCocheras() {
		System.out.println("MAPA DE COCHERAS");
		Iterator<Cochera> it = this.sisCocheras.getCocheras().iterator();
		while(it.hasNext()){
			Cochera cochera = it.next();
			System.out.println(String.format("Chochera: %s - Tamaño: %s - Estado: %s ", cochera.getId(), cochera.getTamano(), cochera.getEstado())); 
		}
		
		this.mostrarMenu();
	}

	private void altaCochera() {
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("ALTA DE COCHERA");
			System.out.println("---------------");
			System.out.print("Ingrese codigo:");
			String id = reader.readLine();
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();
			
			this.sisCocheras.altaCochera(id, tamano);
			
			System.out.print("La cochera fue creada.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}

	private void crearCliente(){
		
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("ALTA DE CLIENTE");
			System.out.println("---------------");
			System.out.print("Ingrese DNI:");
			String dni = reader.readLine();
			System.out.print("Ingrese Nombre:");
			String nombre = reader.readLine();
			System.out.print("Ingrese Domicilio:");
			String domicilio = reader.readLine();
			System.out.print("Ingrese E-mail:");
			String mail = reader.readLine();
			System.out.print("Ingrese telefono:");
			String telefono = reader.readLine();
			
			this.sisCocheras.crearCliente(dni, nombre, mail, domicilio, telefono);
			
			System.out.print("El cliente fue dado de alta.");
				
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private void modificarCliente(){
		
		try{			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("MODIFICACION DE CLIENTE");
			System.out.println("---------------");
			System.out.print("Ingrese DNI:");
			String dni = reader.readLine();
			System.out.print("Ingrese Nombre:");
			String nombre = reader.readLine();
			System.out.print("Ingrese Domicilio:");
			String domicilio = reader.readLine();
			System.out.print("Ingrese E-mail:");
			String mail = reader.readLine();
			System.out.print("Ingrese telefono:");
			String telefono = reader.readLine();
			
			this.sisCocheras.modificarCliente(dni, nombre, mail, domicilio, telefono);
			
			System.out.print("Cliente modificado.");
			
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private void asignarAuto(){
		
		try{
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("ASIGNAR AUTO A CLIENTE");
			System.out.println("---------------");
			System.out.print("Ingrese DNI de Cliente:");
			String dni = reader.readLine();
			System.out.print("Ingrese Patente:");
			String patente = reader.readLine();
			System.out.print("Ingrese Marca:");
			String marca = reader.readLine();			
			System.out.print("Ingrese Modelo:");
			String modelo = reader.readLine();
			
			this.sisCocheras.asignarAuto(dni, patente, marca, modelo);
			System.out.print("Auto asignado.");
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void crearAbono(){
		try{
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("ALTA DE ABONO");
			System.out.println("---------------");
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();
			System.out.print("Ingrese precio:");
			String precio = reader.readLine();
			System.out.print("Ingrese periodo:");
			String periodo = reader.readLine();
			
			this.sisCocheras.altaAbono(tamano, Float.parseFloat(precio), periodo);
			System.out.print("Abono creado.");
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void modificarAbono(){
		try{
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("MODIFICACION DE PRECIO DE ABONO");
			System.out.println("---------------");
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();
			System.out.print("Ingrese precio:");
			String precio = reader.readLine();
			System.out.print("Ingrese periodo:");
			String periodo = reader.readLine();
			
			this.sisCocheras.modificarAbono(tamano, Float.parseFloat(precio), periodo);
			System.out.print("Abono modificado.");
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void bajaAbono(){
		try{
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion			
			System.out.println("BAJA DE ABONO");
			System.out.println("---------------");
			System.out.print("Ingrese tamano:");
			String tamano = reader.readLine();			
			System.out.print("Ingrese periodo:");
			String periodo = reader.readLine();
			
			this.sisCocheras.bajaAbono(tamano, periodo);
			System.out.print("Abono dado de baja.");
			mostrarMenu();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void salir(){
		System.exit(0);
	}
}
