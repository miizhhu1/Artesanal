package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {

	public static void main(String[] args) {
		boolean resultado;
		Maquina rubia = new Maquina("pilsener", "Cerveza fria", 0.02, 8000,"C1");
		System.out.println("----ESTADO INICIAL----");
		rubia.imprimir();
		System.out.println("----RECARGA UNO----");
		resultado=rubia.recargarCerveza(3000);
		System.out.println("Se recarga correctamente " + resultado);
		rubia.imprimir();
		System.out.println("----RECARGA DOS----");
		resultado=rubia.recargarCerveza(2000);
		System.out.println("Se recarga correctamente " + resultado);
		rubia.imprimir();
		System.out.println("----RECARGA TRES----");
		resultado=rubia.recargarCerveza(2800);
		System.out.println("Se recarga correctamente " + resultado);
		rubia.imprimir();
	}

}
