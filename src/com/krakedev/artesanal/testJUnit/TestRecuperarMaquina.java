
package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquina {

    @Test
    public void testRecuperarMaquinaExistente() {

        // Creamos el negocio
        NegocioMejorado negocio = new NegocioMejorado();

        // Agregamos una máquina
        negocio.agregarMaquina(
                "Pilsener",
                "Cerveza artesanal rubia",
                0.05
        );

        // Obtenemos la máquina que agregamos
        Maquina esperada = negocio.getMaquinas().get(0);

        // Buscamos la máquina utilizando su código real
        Maquina resultado =
                negocio.recuperarMaquina(esperada.getCodigo());

        // Verificamos que se encontró la máquina
        assertNotNull(resultado);

        // Verificamos que sea el mismo objeto
        assertSame(esperada, resultado);
    }

    @Test
    public void testRecuperarMaquinaInexistente() {

        // Creamos un negocio sin máquinas
        NegocioMejorado negocio = new NegocioMejorado();

        // Buscamos una máquina en la lista vacía
        Maquina resultado = negocio.recuperarMaquina("M-25");

        // Verificamos que el resultado sea null
        assertNull(resultado);
    }
}

