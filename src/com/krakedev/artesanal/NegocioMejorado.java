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
		// Generamos el codigo de la máquina
		String codigo = generarCodigo();

		// Buscamos si ya existe una máquina con ese código
		Maquina existente = recuperarMaquina(codigo);

		if (existente == null) {
			// creamos la máquina
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

	// registrar cliente
	public void registrarCliente(String nombre, String cedula) {

		// Creamos el objeto Cliente
		Cliente cliente = new Cliente(nombre, cedula);

		// Asignamos el código consecutivo
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo++;

		// Agregamos el cliente a la lista
		clientes.add(cliente);
	}

	// buscar clientes por cedula
	public Cliente buscarCliente(String cedula) {
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getCedula().equals(cedula)) {
				return cliente;
			}
		}
		return null;
	}

	// buscar clientes por codigo
	public Cliente buscarClientePorCodigo(int codigo) {
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getCodigo() == codigo) {
				return cliente;
			}
		}
		return null;
	}

	// consumir cerveza
	public void consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {

		// buscar la máquina por su código
		Maquina maquina = recuperarMaquina(codigoMaquina);

		// buscar el cliente por su código
		Cliente cliente = buscarClientePorCodigo(codigoCliente);

		// invocar servirCerveza y guardar el retorno
		double valor = maquina.servirCerveza(cantidad);

		// registrar y acumular el consumo del cliente
		registrarConsumo(cliente, valor);

	}

	// registrar consumo

	public void registrarConsumo(Cliente cliente, double valor) {

		// Obtener el consumo anterior y sumar el nuevo valor
		cliente.setTotalConsumo(cliente.getTotalConsumo() + valor);
	}

	// consultar el total vendido por el negocio
	public double consultarValorVendido() {

		double totalVendido = 0;
		
		for (int i = 0; i < clientes.size(); i++) {

			Cliente cliente = clientes.get(i);

			// Sumamos el consumo de cada cliente
			totalVendido = totalVendido + cliente.getTotalConsumo();
		}
		return totalVendido;
	}

}
