package com.github.rafaritter44.cloud_native.calculadora.app.operacoes;

import org.junit.Test;
import static org.junit.Assert.*;

public class DivisaoTest {

    @Test
    public void dividir1por0() {
        Operacao operacao = new Divisao(1D, 0D);
        assertFalse(operacao.calcular().isPresent());
    }

    @Test
    public void dividir0por0() {
        Operacao operacao = new Divisao(0D, 0D);
        assertFalse(operacao.calcular().isPresent());
    }

    @Test
    public void dividir20por2() {
        Operacao operacao = new Divisao(20D, 2D);
        assertEquals(10D, (double) operacao.calcular().get(), 0D);
    }
}