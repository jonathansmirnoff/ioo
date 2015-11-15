package cochera;

import java.util.Calendar;
import java.util.Date;

//TODO: Actualizar el diagrama de clases.
public class Movimiento {
	private long nroMovimiento;
	private Date fecha;
	private float monto;
	private float saldo;
	private String descripcion;
	private static int proxNroMovimiento;
	
	public Movimiento(float monto, float saldo, String descripcion){
		this.setNroMovimiento(this.getNroMovimiento());
		this.setMonto(monto);
		this.setSaldo(saldo);
		this.setDescripcion(descripcion);
		this.setFecha(Calendar.getInstance().getTime());		
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getNroMovimiento() {
		return nroMovimiento;
	}

	public void setNroMovimiento(long nroMovimiento) {
		this.nroMovimiento = nroMovimiento;
	}

	public static int getProxNroMovimiento() {
		return ++proxNroMovimiento;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
}
