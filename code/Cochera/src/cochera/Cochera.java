package cochera;

public class Cochera {
	private String id;
	private boolean estaOcupada;
	private String tamano;
	
	public Cochera(String id, String tamano){
		this.setId(id);
		this.setEstaOcupada(false);
		this.setTamano(tamano);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public boolean getEstaOcupada() {
		return estaOcupada;
	}
	
	public void setEstaOcupada(boolean estaOcupada) {
		this.estaOcupada = estaOcupada;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
}
