package com.cochera;

public class Abono {
	private String tamano;
	private float precio;
	private String periodo;
	private int estado;
	
	public Abono(String tamano, float precio, String perido){
		this.setEstado(1);
		this.setPeriodo(perido);
		this.setTamano(tamano);
		this.setPrecio(precio);
	}
	
	public String getTamano() {
		return tamano;
	}
	
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
