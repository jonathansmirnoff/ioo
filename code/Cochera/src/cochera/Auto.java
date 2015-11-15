package cochera;

import java.util.Date;

public class Auto {
	private String patente;
	private String marca;
	private String modelo;
	private Date fechaDeEntrada;
	
	public Auto(String patente, String marca, String modelo){
		this.setPatente(patente);
		this.setFechaDeEntrada(new Date());
		this.setMarca(marca);
		this.setModelo(modelo);		
	}
		
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Date getFechaDeEntrada() {
		return fechaDeEntrada;
	}
	public void setFechaDeEntrada(Date fechaDeEntrada) {
		this.fechaDeEntrada = fechaDeEntrada;
	}	
}
