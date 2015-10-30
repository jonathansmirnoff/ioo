package com.cochera;

public class MedioDePago {
	private String tipo;
	private String entidad;
	private int estado;
	
	public MedioDePago(String tipo, String entidad){
		this.setEntidad(entidad);
		this.setEstado(1);
		this.setTipo(tipo);
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getEntidad() {
		return entidad;
	}
	
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}		
}