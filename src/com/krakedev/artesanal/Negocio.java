package com.krakedev.artesanal;

public class Negocio {

	private String nombre;
	// metemos un objeto dentro de otro objeto
	private Maquina maquinaA;
	private int ultimoCodigo=100;

	// constructor Negocio
	public Negocio() {
		
	}
	
	public Negocio(String nombre, Maquina maquinaA) {
		this.nombre = nombre;
		this.maquinaA = maquinaA;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Maquina getMaquinaA() {
		return maquinaA;
	}

	public void setMaquinaA(Maquina maquinaA) {
		this.maquinaA = maquinaA;
	}
	
	//metodo
	//tipo de dato Cliente y variable cliente
	public void asignarCodigoCliente(Cliente cliente) {
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo++;// se suma uno
	}

	
	public void cargarMaquinaA() {
		maquinaA.llenarMaquina();
	}
	
	public void consumirCervezaMaquinaA(Cliente cliente, double ml) {
		double valor= maquinaA.servirCerveza(ml);
		cliente.setTotalConsumo(cliente.getTotalConsumo()+valor);
		
	}
}
