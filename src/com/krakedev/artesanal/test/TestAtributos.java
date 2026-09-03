package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maquina rubia = new Maquina("Pilsener","Rubia",0.02,100000,"C1");
		rubia.imprimir();
		rubia.setNombreCerveza("Golden");
		rubia.setDescripcion("Cerveza amarilla");
		rubia.imprimir();
	}

}
