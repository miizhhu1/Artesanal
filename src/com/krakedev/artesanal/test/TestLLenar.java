package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLLenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maquina rubia = new Maquina("pilsener", "Cerveza fria", 0.02, 8000,"C1");

		rubia.imprimir();
		rubia.llenarMaquina();
		rubia.imprimir();
		
		Maquina negra = new Maquina("club", "Cerveza buena", 0.03,"C2");

		negra.imprimir();
		negra.llenarMaquina();
		negra.imprimir();
		
	}

}
