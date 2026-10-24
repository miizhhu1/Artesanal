package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	ArrayList<Maquina> maquinas;

	// Constructor
	public NegocioMejorado() {
		maquinas = new ArrayList<Maquina>();
	}

	// Getter and Setter

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

	// agregar maquina
	public void agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		// 1. Generamos el código de la máquina
		String codigo = generarCodigo();

		// 2. Creamos el objeto Maquina con los datos recibidos
		Maquina maquina = new Maquina(nombreCerveza, descripcion, precioPorMl, codigo);
		
		// 3. Agregamos la máquina a la lista
		maquinas.add(maquina);
	}
	
	// cargar maquina
	
	public void cargarMaquina() {
		for(int i = 0; i<maquinas.size(); i++) {
			maquinas.get(i).llenarMaquina();
		}
	}
	
	//recuperar maquina
	
	public  Maquina recuperarMaquina(String  codigo) {
		for(int i=0; i<maquinas.size(); i++) {
			Maquina m = maquinas.get(i);
			// Comparamos el código recibido con el de la máquina
			if(m.getCodigo().equals(codigo)) {
				return m;
			}
		}
		return null;
		
	}
}
