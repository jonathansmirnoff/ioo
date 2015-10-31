package com.cochera;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

public class SistemaAdministracionCochera {
	private Vector<Cliente> clientes;
	private Vector<Abono> abonos;
	private Vector<MedioDePago> mediosDePago;
	private Vector<Cochera> cocheras;
	private Vector<Contrato> contratos;
	
	public SistemaAdministracionCochera(){
		this.clientes = new Vector<Cliente>();
		this.abonos = new Vector<Abono>();
		this.cocheras = new Vector<Cochera>();
		this.mediosDePago = new Vector<MedioDePago>();
		this.contratos = new Vector<Contrato>();
	}
	
	public void crearCliente(String dni, String nombre, String email, String domicilio, String telefono){
		Cliente cliente = this.buscarCliente(dni);
		if (cliente == null){
			Cliente nuevoCliente = new Cliente(nombre, domicilio, telefono, email, dni);
			this.clientes.add(nuevoCliente);
		}
	}
	
	public void modificarCliente(String dni, String nombre, String email, String domicilio, String telefono){
		Cliente cliente = this.buscarCliente(dni);
		if (cliente != null){
			cliente.setDni(dni);
			cliente.setDomicilio(domicilio);
			cliente.setTelefono(telefono);
			cliente.setMail(email);
			cliente.setNombre(nombre);			
		}
	}
	
	public void bajaCliente(String dni){
		Cliente cliente = this.buscarCliente(dni);
		if (cliente != null){
			float deudas = 0;
			Vector<Contrato> contratosDeCliente = buscarContratos(cliente);
			for(int i=0; i < contratosDeCliente.size(); i++){
				deudas += contratosDeCliente.get(i).obtenerDeudas();
			}
			
			if (deudas == 0){
				for(int i=0; i < contratosDeCliente.size(); i++){
					contratosDeCliente.get(i).bajaContrato();
				}
				
				cliente.setEstaActivo(false);
			}				
		}
	}
	
	public void asignarAuto(String dniCliente, String patente, String marca, String modelo){
		Cliente cliente = this.buscarCliente(dniCliente);
		if(cliente != null){
			Auto auto = cliente.buscarAutoPorPatente(patente);
			if (auto == null){
				cliente.crearAuto(patente, marca, modelo);
			}
		}
	}
	
	public void altaAbono(String tamano, float precio, String periodo){
		Abono abono = this.buscarAbono(tamano, periodo);
		if (abono == null){
			this.getAbonos().add(new Abono(tamano, precio, periodo));
		}
	}
	
	public void modificarAbono(String tamano, float precio, String periodo){
		Abono abono = this.buscarAbono(tamano, periodo);
		if (abono != null){			
			abono.setPrecio(precio);			
		}
	}
	
	public void bajaAbono(String tamano, String periodo){
		Abono abono = this.buscarAbono(tamano, periodo);
		if (abono != null){
			//TODO: Falta validar que se no se esté usando en ningun contrato.
			abono.setEstado(0);			
		}
	}
	
	public void altaCochera(String idCochera, String tamano){
		Cochera cochera = this.buscarCochera(idCochera);
		if (cochera == null){
			this.getCocheras().add(new Cochera(idCochera, tamano));
		}
	}
	
	public void altaMedioDePago(String tipo, String entidad){
		MedioDePago medio = this.buscarMedioDePago(tipo, entidad);
		if (medio == null){
			this.getMediosDePago().add(new MedioDePago(tipo, entidad));
		}
	}
	
	public void bajaMedioDePago(String tipo, String entidad){
		MedioDePago medio = this.buscarMedioDePago(tipo, entidad);
		if (medio != null){
			medio.setEstado(0);
		}
	}
	
	public void altaContratoDebitoCBU(String dniCliente, String idCochera, String tamano, String periodo, String entidad, String cbu, String patente){
		Cliente cliente = this.buscarCliente(dniCliente);
		Cochera cochera = this.buscarCochera(idCochera);
		Abono abono = this.buscarAbono(tamano, periodo);
		
		if (cliente != null && cochera != null && abono != null){
			Auto auto = cliente.buscarAutoPorPatente(patente);
			if (auto != null){
				Contrato con = buscarContratoPorClienteCochera(cliente, auto);
				if (con == null){
					this.contratos.add(new DebitoCBU(abono, cochera, auto, cliente, entidad, cbu));
				}
			}
		}
	}
	
	public void altaContratoEfectivo(String dniCliente, String idCochera, String tamano, String periodo, String patente){
		Cliente cliente = this.buscarCliente(dniCliente);
		Cochera cochera = this.buscarCochera(idCochera);
		Abono abono = this.buscarAbono(tamano, periodo);
		
		if (cliente != null && cochera != null && abono != null){
			Auto auto = cliente.buscarAutoPorPatente(patente);
			if (auto != null){
				Contrato con = buscarContratoPorClienteCochera(cliente, auto);
				if (con == null){
					this.contratos.add(new Efectivo(abono, cochera, auto, cliente));
				}
			}
		}
	}
	
	public void altaContratoCheque(String dniCliente, String idCochera, String tamano, String periodo, String patente){
		Cliente cliente = this.buscarCliente(dniCliente);
		Cochera cochera = this.buscarCochera(idCochera);
		Abono abono = this.buscarAbono(tamano, periodo);
		
		if (cliente != null && cochera != null && abono != null){
			Auto auto = cliente.buscarAutoPorPatente(patente);
			if (auto != null){
				Contrato con = buscarContratoPorClienteCochera(cliente, auto);
				if (con == null){
					this.contratos.add(new Cheque(abono, cochera, auto, cliente));
				}
			}
		}
	}
	
	public void altaContratoDebitoTarjetaCredito(String dniCliente, String idCochera, String tamano, String periodo, String patente, String entidad, String numero, Date fechaDeVencimiento){
		Cliente cliente = this.buscarCliente(dniCliente);
		Cochera cochera = this.buscarCochera(idCochera);
		Abono abono = this.buscarAbono(tamano, periodo);
		
		if (cliente != null && cochera != null && abono != null){
			Auto auto = cliente.buscarAutoPorPatente(patente);
			if (auto != null){
				Contrato con = buscarContratoPorClienteCochera(cliente, auto);
				if (con == null){
					this.contratos.add(new DebitoTarjetaCredito(abono, cochera, auto, cliente, entidad, numero, fechaDeVencimiento));
				}
			}
		}
	}
	
	public void modificarContratoDebitoCBU(int idContrato, String dniCliente, String idCochera, String tamano, String periodo, String entidad, String cbu, String patente){
		Cliente cliente = this.buscarCliente(dniCliente);
		Cochera cochera = this.buscarCochera(idCochera);
		Abono abono = this.buscarAbono(tamano, periodo);
		Contrato contrato = this.buscarContratoPorNumero(idContrato);
		
		if (cliente != null && cochera != null && abono != null && contrato != null){
			((DebitoCBU)contrato).liberarCochera();
			((DebitoCBU)contrato).setCochera(cochera);
			((DebitoCBU)contrato).ocuparCochera();
			((DebitoCBU)contrato).setCliente(cliente);
			((DebitoCBU)contrato).setAbono(abono);
			((DebitoCBU)contrato).setEntidad(entidad);
			((DebitoCBU)contrato).setCbu(cbu);
		}
	}
	
	public void modificarEfectivo(int idContrato, String dniCliente, String idCochera, String tamano, String periodo, String patente){
		Cliente cliente = this.buscarCliente(dniCliente);
		Cochera cochera = this.buscarCochera(idCochera);
		Abono abono = this.buscarAbono(tamano, periodo);
		Contrato contrato = this.buscarContratoPorNumero(idContrato);
		
		if (cliente != null && cochera != null && abono != null && contrato != null){
			((Efectivo)contrato).liberarCochera();
			((Efectivo)contrato).setCochera(cochera);
			((Efectivo)contrato).ocuparCochera();
			((Efectivo)contrato).setCliente(cliente);
			((Efectivo)contrato).setAbono(abono);
		}
	}
	
	public void modificarDebitoTarjetaCredito(int idContrato, String dniCliente, String idCochera, String tamano, String periodo, String patente, String entidad, String numero, Date fechaDeVencimiento){
		Cliente cliente = this.buscarCliente(dniCliente);
		Cochera cochera = this.buscarCochera(idCochera);
		Abono abono = this.buscarAbono(tamano, periodo);
		Contrato contrato = this.buscarContratoPorNumero(idContrato);
		
		if (cliente != null && cochera != null && abono != null && contrato != null){
			((DebitoTarjetaCredito)contrato).liberarCochera();
			((DebitoTarjetaCredito)contrato).setCochera(cochera);
			((DebitoTarjetaCredito)contrato).ocuparCochera();
			((DebitoTarjetaCredito)contrato).setCliente(cliente);
			((DebitoTarjetaCredito)contrato).setAbono(abono);
			((DebitoTarjetaCredito)contrato).setEntidad(entidad);
			((DebitoTarjetaCredito)contrato).setNumero(numero);
			((DebitoTarjetaCredito)contrato).setFechaVencimiento(fechaDeVencimiento);
		}
	}
	
	public void modificarCheque(int idContrato, String dniCliente, String idCochera, String tamano, String periodo, String patente){
		Cliente cliente = this.buscarCliente(dniCliente);
		Cochera cochera = this.buscarCochera(idCochera);
		Abono abono = this.buscarAbono(tamano, periodo);
		Contrato contrato = this.buscarContratoPorNumero(idContrato);
		
		if (cliente != null && cochera != null && abono != null && contrato != null){
			((Cheque)contrato).liberarCochera();
			((Cheque)contrato).setCochera(cochera);
			((Cheque)contrato).ocuparCochera();
			((Cheque)contrato).setCliente(cliente);
			((Cheque)contrato).setAbono(abono);
		}
	}
	
	public void bajaContrato(int idContrato){
		Contrato contrato = this.buscarContratoPorNumero(idContrato);
		
		if (contrato != null && ((DebitoCBU)contrato).obtenerDeudas() == 0){
			((DebitoCBU)contrato).liberarCochera();
			((DebitoCBU)contrato).setEstado(0);
		}
	}
	
	
	private Contrato buscarContratoPorClienteCochera(Cliente cliente, Auto auto) {
		Iterator<Contrato> it = this.getContratos().iterator();
		while(it.hasNext()){
			Contrato contrato = it.next();
			if (contrato.getCliente().getDni().equals(cliente.getDni()) && 
					contrato.getAuto().getPatente().equals(auto.getPatente()) &&
					contrato.getEstado() == 1){
				return contrato;
			}
		}		
		return null;
	}
	
	private Contrato buscarContratoPorNumero(int nroContrato) {
		Iterator<Contrato> it = this.getContratos().iterator();
		while(it.hasNext()){
			Contrato contrato = it.next();
			if (contrato.getNroContrato() == nroContrato && contrato.getEstado() == 1){
				return contrato;
			}
		}
		return null;
	}
	
	private Vector<Contrato> buscarContratos(Cliente cliente) {
		Iterator<Contrato> it = this.getContratos().iterator();
		Vector<Contrato> contratos = new Vector<Contrato>();
		while(it.hasNext()){
			Contrato contrato = it.next();
			if (contrato.getCliente().getDni().equals(cliente.getDni())){
				contratos.add(contrato);
			}
		}
		
		return contratos;
	}

	private MedioDePago buscarMedioDePago(String tipo, String entidad){
		Iterator<MedioDePago> it = this.getMediosDePago().iterator();
		while(it.hasNext()){
			MedioDePago medioDePago = it.next();
			if (medioDePago.getTipo().equals(tipo) && 
					medioDePago.getEntidad().equals(entidad) &&
					medioDePago.getEstado() == 1){
				return medioDePago;
			}
		}		
		return null;		
	}
	
	private Cochera buscarCochera(String idCochera){
		Iterator<Cochera> it = this.getCocheras().iterator();
		while(it.hasNext()){
			Cochera cochera = it.next();
			if (cochera.getId().equals(idCochera) && cochera.getEstado() == 0){
				return cochera;
			}
		}
		
		return null;
	}

	public Vector<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Vector<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public Vector<Abono> getAbonos() {
		return abonos;
	}

	public void setAbonos(Vector<Abono> abonos) {
		this.abonos = abonos;
	}
	
	private Cliente buscarCliente(String dniCliente){
		Iterator<Cliente> it = this.getClientes().iterator();
		while(it.hasNext()){
			Cliente cte = it.next();
			if (cte.getDni().equals(dniCliente) && cte.getEstaActivo()){
				return cte;
			}
		}
		
		return null;
	}
	
	private Abono buscarAbono(String tamano, String periodo){
		Iterator<Abono> it = this.getAbonos().iterator();
		while(it.hasNext()){
			Abono abono = it.next();
			if (abono.getTamano().equals(tamano) 
					&& abono.getPeriodo().equals(periodo) 
					&& abono.getEstado() == 1){
				return abono;
			}
		}
		
		return null;
	}

	public Vector<Cochera> getCocheras() {
		return this.cocheras;
	}

	public void setCocheras(Vector<Cochera> cocheras) {
		this.cocheras = cocheras;
	}

	public Vector<MedioDePago> getMediosDePago() {
		return mediosDePago;
	}

	public void setMediosDePago(Vector<MedioDePago> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}

	public Vector<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(Vector<Contrato> contratos) {
		this.contratos = contratos;
	}
}
