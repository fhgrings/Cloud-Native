package com.github.rafaritter44.cloud_native.calculadora.app.operacoes;

import org.junit.Test;
import static org.junit.Assert.*;

public class SubtracaoTest {

    @Test
    public void calcular() {
        Operacao operacao = new Subtracao(5D, 8D);
        assertEquals(-3D, (double) operacao.calcular().get(), 0D);
    }

}