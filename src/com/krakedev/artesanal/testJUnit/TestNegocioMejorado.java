package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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

}
