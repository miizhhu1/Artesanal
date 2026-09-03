package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {

    @Test
    public void probarServirCervezaConSuficienteCantidad() {

        // Se utiliza el constructor que recibe capacidadMaxima
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 1000,"C1");

        // Se recarga la máquina con 500 ml
        maquina.recargarCerveza(500);

        // Se sirven 200 ml
        double valor = maquina.servirCerveza(200);

        // Se valida que el valor a pagar sea cantidad servida * precio por ml
        assertEquals(10.0, valor, 0.0001);

        // Se valida que la cantidad actual haya disminuido en 200 ml
        assertEquals(300.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void probarServirCervezaCuandoNoHaySuficienteCantidad() {

        // Se utiliza el constructor que no recibe capacidadMaxima
        Maquina maquina = new Maquina("Club", "Cerveza lager", 0.04,"C2");

        // Se recarga la máquina con 500 ml
        maquina.recargarCerveza(500);

        // Se intenta servir una cantidad mayor a la disponible
        double valor = maquina.servirCerveza(600);

        // Se valida que no se cobre nada porque no se pudo servir
        assertEquals(0.0, valor, 0.0001);

        // Se valida que la cantidad actual no haya cambiado
        assertEquals(500.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void probarServirExactamenteTodaLaCantidadDisponible() {

        // Se utiliza el constructor que recibe capacidadMaxima
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.03, 1000,"C3");

        // Se recarga la máquina con 500 ml
        maquina.recargarCerveza(500);

        // Se sirve exactamente toda la cantidad disponible
        double valor = maquina.servirCerveza(500);

        // Se valida que se cobre correctamente por los 500 ml servidos
        assertEquals(15.0, valor, 0.0001);

        // Se valida que la cantidad actual quede en cero
        assertEquals(0.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void probarServirCervezaCuandoLaMaquinaEstaVacia() {

        // Se utiliza el constructor que no recibe capacidadMaxima
        Maquina maquina = new Maquina("Club", "Cerveza lager", 0.05,"C4");

        // La máquina comienza sin cerveza disponible

        // Se intenta servir 200 ml
        double valor = maquina.servirCerveza(200);

        // Se valida que no se cobre nada
        assertEquals(0.0, valor, 0.0001);

        // Se valida que la cantidad actual continúe en cero
        assertEquals(0.0, maquina.getCantidadActual(), 0.0001);
    }
}