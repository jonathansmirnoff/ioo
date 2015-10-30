package com.cochera;

public class Cochera {
	private String id;
	private int estado; //Ocupado 1; Libre 0
	private String tamano;
	
	public Cochera(String id, String tamano){
		this.setId(id);
		this.setEstado(0);
		this.setTamano(tamano);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
}
