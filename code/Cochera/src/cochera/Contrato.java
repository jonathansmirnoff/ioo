package cochera;

import java.util.Calendar;
import java.util.Date;

public abstract class Contrato {
	
	private Abono abono;
	private Cliente cliente;
	private Cochera cochera;
	private boolean estaActivo;
	private Auto auto;
	private Cuenta cuenta;
	private static int proxNroContrato;
	private int nroContrato;
	private Date fechaDeCreacion;
	
	public Contrato(Abono abono, Cochera cochera, Auto auto, Cliente cliente){
		this.setAbono(abono);
		this.setCochera(cochera);
		this.setCliente(cliente);
		this.setAuto(auto);
		this.setCuenta(new Cuenta());
		this.setEstaActivo(true);		
		this.ocuparCochera();
		this.setNroContrato(getProxNroContrato());
		//TODO: Actualizar el diagrama de clase. Se crea un contrato con la fecha actual.
		this.setFechaDeCreacion(Calendar.getInstance().getTime());		
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
	public boolean getEstaActivo() {
		return estaActivo;
	}
	public void setEstaActivo(boolean estaActivo) {
		this.estaActivo = estaActivo;
	}
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public void ocuparCochera(){
		if (this.cochera != null){
			this.cochera.setEstaOcupada(true);
		}
	}
	
	public void liberarCochera(){
		if (this.cochera != null){
			this.cochera.setEstaOcupada(false);
		}
	}
	
	public int getNroContrato() {
		return nroContrato;
	}

	public void setNroContrato(int nroContrato) {
		this.nroContrato = nroContrato;
	}
	
	public void bajaContrato() {		
		setEstaActivo(false);
		getCochera().setEstaOcupada(false);	
	}

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	public void cobrarCuota(float monto, String descripcion){
		getCuenta().cobrar(monto, descripcion);
	}
	
	public Date getFechaUltimoMovimiento(){		
		if (getCuenta().getMovimientos().size() == 0){
			return this.getFechaDeCreacion();
		}
		else{
			Movimiento mov = getCuenta().getMovimientos().lastElement();		
			if (mov.getMonto() < 0){
				//Es la última cuota generada
			}else{
				//Si no es la última cuota generada, es un pago. Entonces recupero la cuota que generó ese pago.				
				mov = getCuenta().getMovimientos().get(getCuenta().getMovimientos().size() - 2);
			}
			
			return mov.getFecha();
		}
	}
	
	public boolean seDebeGenerarCuota(){
		Date fechaProximoVencimiento = this.agregarDias(this.getFechaUltimoMovimiento(), 
				getAbono().getPeriodo());
		
		return fechaProximoVencimiento.after(Calendar.getInstance().getTime());				
	}
	
	public void generarCuota(){
		this.getCuenta().generarCuota(this.getAbono().getPrecio(), "Cuota");				
	}
	
	public void pagarCuota(float monto){
		this.getCuenta().cobrar(monto, "Pago de Cuota");
	}
	
	private Date agregarDias(Date fecha, String periodo){
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		
		switch (periodo) {
			case "Quincenal":
				cal.add(Calendar.DATE, 15);
				break;
			case "Mensual":	
				cal.add(Calendar.DATE, 30);
				break;
			case "Semestral":
				cal.add(Calendar.DATE, 60);
				break;
		}
		
		return cal.getTime();
	}
	
	public abstract float obtenerDeudas();
}
