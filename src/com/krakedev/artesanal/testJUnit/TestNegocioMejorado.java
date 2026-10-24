package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejorado {

	@Test
	public void testGenerarCodigo() {

		// Creamos el objeto que vamos a probar
		NegocioMejorado negocio = new NegocioMejorado();

		// Generamos varios códigos para comprobar su formato y rango
		for (int i = 0; i < 100; i++) {

			String codigo = negocio.generarCodigo();

			// Verificamos que el código no sea null
			assertNotNull(codigo);

			// Verificamos que comience con M- y tenga un número
			assertTrue(codigo.matches("M-\\d+"));

			// Extraemos el número que está después de M-
			int numero = Integer.parseInt(codigo.substring(2));

			// Verificamos que el número esté entre 1 y 100
			assertTrue(numero >= 1 && numero <= 100);
		}
	}

	@Test
	public void testInicializarListaMaquinas() {

		// Creamos el objeto NegocioMejorado
		NegocioMejorado negocio = new NegocioMejorado();

		// Verificamos que la lista exista y esté vacía
		assertNotNull(negocio.getMaquinas());
		assertTrue(negocio.getMaquinas().isEmpty());
	}

	@Test
	public void testClienteActualizado() {

		// Crear el negocio
		NegocioMejorado negocio = new NegocioMejorado();

		// Registrar el cliente
		negocio.registrarCliente("Ana", "1712345678");

		// Buscar al cliente
		Cliente cliente = negocio.buscarClientePorCodigo(100);

		// Comprobar que existe
		assertNotNull(cliente);

		// Registrar un consumo de prueba de 2 dólares
		negocio.registrarConsumo(cliente, 2.0);

		// Registrar otro consumo de 3 dólares
		negocio.registrarConsumo(cliente, 3.0);

		// Verificar que se acumularon ambos consumos
		assertEquals(5.0, cliente.getTotalConsumo(), 0.001);
	}

	@Test
	public void testMaquinaAfectada() {

		// Crear una máquina con capacidad de 1000 ml
		Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.02, 1000, "M-1");

		// Llenar la máquina
		maquina.llenarMaquina();

		// Guardar la cantidad inicial
		double cantidadInicial = maquina.getCantidadActual();

		// Servir 100 ml de cerveza
		maquina.servirCerveza(100);

		// Comprobar que disminuyó la cantidad servida
		assertEquals(cantidadInicial - 100, maquina.getCantidadActual(), 0.001);
	}

	@Test
	public void testValoresCorrectos() {

		// Crear una máquina cuyo precio es 0.02 por ml
		Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.02, 1000, "M-1");

		// Llenar la máquina
		maquina.llenarMaquina();

		// Servir 100 ml y guardar el valor devuelto
		double valor = maquina.servirCerveza(100);

		// Verificar que el precio sea 2 dólares
		assertEquals(2.0, valor, 0.001);

		// Verificar que la máquina tenga 800 ml
		assertEquals(800.0, maquina.getCantidadActual(), 0.001);
	}
	
	 @Test
	    public void testConsultarValorVendido() {

	        // Creamos el objeto del negocio
	        NegocioMejorado negocio = new NegocioMejorado();

	        // Registramos los clientes
	        negocio.registrarCliente("Ana", "123");
	        negocio.registrarCliente("Pedro", "456");
	        negocio.registrarCliente("Luis", "789");

	        // Registramos los consumos de cada cliente
	        negocio.registrarConsumo(negocio.buscarCliente("123"), 5.00);
	        negocio.registrarConsumo(negocio.buscarCliente("456"), 3.50);
	        negocio.registrarConsumo(negocio.buscarCliente("789"), 2.00);

	        // Consultamos el total vendido
	        double total = negocio.consultarValorVendido();

	        // Verificamos que el resultado sea correcto
	        assertEquals(10.50, total, 0.001);
	    }
	 
	 
}
