package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*NegocioMejorado negocio = new NegocioMejorado();
		negocio.registrarCliente("Ana", "1712345678");*/
		
		
		//Prueba
		// Creamos el objeto del negocio
        NegocioMejorado negocio = new NegocioMejorado();

        // Registramos tres clientes
        negocio.registrarCliente("Ana", "123");
        negocio.registrarCliente("Pedro", "456");
        negocio.registrarCliente("Luis", "789");

        // Buscamos los clientes registrados
        Cliente cliente1 = negocio.buscarCliente("123");
        Cliente cliente2 = negocio.buscarCliente("456");
        Cliente cliente3 = negocio.buscarCliente("789");

        // Registramos el consumo de cada cliente
        negocio.registrarConsumo(cliente1, 5.00);
        negocio.registrarConsumo(cliente2, 3.50);
        negocio.registrarConsumo(cliente3, 2.00);

        // Mostramos el consumo de cada cliente
        System.out.println("Consumo de Ana: " 
                + cliente1.getTotalConsumo());

        System.out.println("Consumo de Pedro: " 
                + cliente2.getTotalConsumo());

        System.out.println("Consumo de Luis: " 
                + cliente3.getTotalConsumo());

        // Consultamos e imprimimos el total vendido
        double total = negocio.consultarValorVendido();

        System.out.println("Total vendido: $" + total);
	}

}
