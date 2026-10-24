
package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquina {

    @Test
    public void testAgregarMaquinaCorrectamente() {

        // Creamos un negocio que genera un código fijo
        NegocioMejorado negocio = new NegocioMejorado() {
            @Override
            public String generarCodigo() {
                return "M-25";
            }
        };

        // Intentamos agregar una máquina
        boolean resultado = negocio.agregarMaquina(
                "Pilsener",
                "Cerveza artesanal rubia",
                0.05
        );

        // Verificamos que la máquina se agregó
        assertTrue(resultado);

        // Verificamos que exista una máquina en la lista
        assertEquals(1, negocio.getMaquinas().size());
    }

    @Test
    public void testNoAgregarMaquinaDuplicada() {

        // Creamos un negocio que genera siempre el mismo código
        NegocioMejorado negocio = new NegocioMejorado() {
            @Override
            public String generarCodigo() {
                return "M-25";
            }
        };

        // Agregamos la primera máquina
        boolean primera = negocio.agregarMaquina(
                "Pilsener",
                "Cerveza rubia",
                0.05
        );

        // Intentamos agregar otra máquina con el mismo código
        boolean segunda = negocio.agregarMaquina(
                "Club",
                "Cerveza premium",
                0.08
        );

        // La primera debe agregarse correctamente
        assertTrue(primera);

        // La segunda debe rechazarse por código duplicado
        assertFalse(segunda);

        // Solo debe existir una máquina
        assertEquals(1, negocio.getMaquinas().size());
    }
}
