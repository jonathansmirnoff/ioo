package com.cochera;

import java.util.Iterator;
import java.util.Vector;

public class Cliente {
	private String nombre;
	private String domicilio;
	private String telefono;
	private String mail;
	private String dni;
	private Boolean estaActivo;
	private Vector<Auto> autos;
	
	public Cliente(String nombre, String domicilio, String telefono, String mail, String dni){
		this.autos = new Vector<Auto>();
		this.setNombre(nombre);
		this.setDni(dni);
		this.setDomicilio(domicilio);
		this.setMail(mail);
		this.setTelefono(telefono);
		this.setEstaActivo(true);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public Boolean getEstaActivo() {
		return estaActivo;
	}

	public void setEstaActivo(Boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	public Vector<Auto> getAutos() {
		return this.autos;
	}

	public void crearAuto(String patente, String marca, String modelo) {
		this.autos.add(new Auto(patente, marca, modelo));
	}
	
	public Auto buscarAutoPorPatente(String patente){
		Iterator<Auto> it = this.getAutos().iterator();
		while(it.hasNext()){
			Auto cte = it.next();
			if (cte.getPatente().equals(patente)){
				return cte;
			}
		}
		
		return null;
	}

}
