package cochera;

import java.util.Date;

public class DebitoTarjetaCredito extends Contrato {
	private String entidad;
	private String numero;
	private Date fechaVencimiento;
	
	public DebitoTarjetaCredito(Abono abono, Cochera cochera, Auto auto, Cliente cliente, String entidad, String numero, Date fechaVencimiento){
		super(abono, cochera, auto, cliente);
		this.setEntidad(entidad);
		this.setNumero(numero);
		this.setFechaVencimiento(fechaVencimiento);
	}
	

	@Override
	public float obtenerDeudas() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

}
