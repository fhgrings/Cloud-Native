package com.github.rafaritter44.cloud_native.calculadora.app.operacoes;

import org.junit.Test;
import static org.junit.Assert.*;

public class AdicaoTest {

    @Test
    public void calcular() {
        Operacao operacao = new Adicao(1D, 2D);
        assertEquals(3D, (double) operacao.calcular().get(), 0D);
    }

}