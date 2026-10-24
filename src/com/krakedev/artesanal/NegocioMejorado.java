package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private int ultimoCodigo = 100;
	
	

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
	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		// Generamos el código de la máquina
		String codigo = generarCodigo();

		// Buscamos si ya existe una máquina con ese código
		Maquina existente = recuperarMaquina(codigo);

		if (existente == null) {
			//creamos la máquina
			Maquina maquina = new Maquina(nombreCerveza, descripcion, precioPorMl, codigo);
			maquinas.add(maquina);
			return true;
		} else {
			return false;
		}
	}

	// cargar maquina

	public void cargarMaquina() {
		for (int i = 0; i < maquinas.size(); i++) {
			maquinas.get(i).llenarMaquina();
		}
	}

	// recuperar maquina

	public Maquina recuperarMaquina(String codigo) {
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina m = maquinas.get(i);
			// Comparamos el código recibido con el de la máquina
			if (m.getCodigo().equals(codigo)) {
				return m;
			}
		}
		return null;

	}
	
	//registrar cliente
	public void registrarCliente(String nombre, String cedula) {

	    // Creamos el objeto Cliente
	    Cliente cliente = new Cliente(nombre, cedula);

	    // Asignamos el código consecutivo
	    cliente.setCodigo(ultimoCodigo);
	    ultimoCodigo++;

	    // Agregamos el cliente a la lista
	    clientes.add(cliente);
	}
	

}
