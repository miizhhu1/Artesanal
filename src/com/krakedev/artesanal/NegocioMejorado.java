package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	ArrayList<Maquina> maquinas;
	
	 // Constructor
    public NegocioMejorado() {
        maquinas = new ArrayList<Maquina>();
    }
    
    //Getter and Setter

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	
	// Genera un código aleatorio entre M-1 y M-100
    public String generarCodigo() {
        int numero;

        // Math.random() genera un decimal desde 0.0 hasta menos de 1.0
        numero = (int) (Math.random() * 100) + 1;

        // Convertimos el número en un código String
        return "M-" + numero;
    }
	
}
