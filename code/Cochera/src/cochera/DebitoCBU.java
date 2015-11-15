package cochera;

public class DebitoCBU extends Contrato {	
	private String entidad;
	private String cbu;
	
	public DebitoCBU(Abono abono, Cochera cochera, Auto auto, Cliente cliente, String entidad, String cbu){
		super(abono, cochera, auto, cliente);		
		this.setCbu(cbu);
		this.setEntidad(entidad);
	}	

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	@Override
	public float obtenerDeudas() {
		// TODO Auto-generated method stub
		return 0;
	}
}
