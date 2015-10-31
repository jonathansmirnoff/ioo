package com.cochera;

public abstract class Contrato {
	
	private Abono abono;
	private Cliente cliente;
	private Cochera cochera;
	private int estado;
	private Auto auto;
	private CtaCte cuenta;
	private static int proxNroContrato;
	private int nroContrato;
	
	public Contrato(Abono abono, Cochera cochera, Auto auto, Cliente cliente){
		this.setAbono(abono);
		this.setCochera(cochera);
		this.setCliente(cliente);
		this.setAuto(auto);
		this.setCuenta(new CtaCte());
		this.setEstado(1);		
		this.ocuparCochera();
		this.setNroContrato(getProxNroContrato());
	}
	
	private static int getProxNroContrato()
	{
		return ++proxNroContrato;
	}
		
	public Abono getAbono() {
		return abono;
	}
	public void setAbono(Abono abono) {
		this.abono = abono;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cochera getCochera() {
		return cochera;
	}
	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	public CtaCte getCuenta() {
		return cuenta;
	}
	public void setCuenta(CtaCte cuenta) {
		this.cuenta = cuenta;
	}
	
	public void ocuparCochera(){
		if (this.cochera != null){
			this.cochera.setEstado(1);
		}
	}
	
	public void liberarCochera(){
		if (this.cochera != null){
			this.cochera.setEstado(0);
		}
	}
	
	public int getNroContrato() {
		return nroContrato;
	}

	public void setNroContrato(int nroContrato) {
		this.nroContrato = nroContrato;
	}
	
	public abstract float obtenerDeudas();

	public void bajaContrato() {
		setEstado(0);
		//Libero la cochera!
		getCochera().setEstado(0);
	}
}
