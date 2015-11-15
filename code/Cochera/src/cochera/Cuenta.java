package cochera;

import java.util.Vector;

//TODO: Cambiar a cuenta en el diagrama de clases
public class Cuenta {
	private Vector<Movimiento> movimientos;
	private float saldo;
	private long nroCuenta;
	private static long proxNroCuenta;

	public Cuenta(){
		this.setMovimientos(new Vector<Movimiento>());
		this.setSaldo(0);
		this.setNroCuenta(this.getNroCuenta());
	}

	public Vector<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Vector<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public long getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(long nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public static long getProxNroCuenta() {
		return ++proxNroCuenta;
	}
	
	public void generarCuota(float monto, String descripcion){
		this.setSaldo(this.getSaldo() - monto);
		this.getMovimientos().add(new Movimiento((-1) * monto, this.getSaldo(), descripcion));
	}
	
	public void cobrar(float monto, String descripcion){
		this.setSaldo(this.getSaldo() + monto);
		this.getMovimientos().add(new Movimiento(monto, this.getSaldo(), descripcion));
	}
}
