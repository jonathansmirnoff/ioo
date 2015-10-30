package com.cochera;

public class Efectivo extends Contrato {
	
	public Efectivo(Abono abono, Cochera cochera, Auto auto, Cliente cliente){
		super(abono, cochera, auto, cliente);
	}

	@Override
	public float obtenerDeudas() {
		// TODO Auto-generated method stub
		return 0;
	}

}
