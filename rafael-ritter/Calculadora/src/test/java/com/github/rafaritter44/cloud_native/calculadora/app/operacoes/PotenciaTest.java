package com.github.rafaritter44.cloud_native.calculadora.app.operacoes;

import org.junit.Test;
import static org.junit.Assert.*;

public class PotenciaTest {

    @Test
    public void calcular() {
        Operacao operacao = new Potencia(2D, 10D);
        assertEquals(1024D, (double) operacao.calcular().get(), 0D);
    }

}