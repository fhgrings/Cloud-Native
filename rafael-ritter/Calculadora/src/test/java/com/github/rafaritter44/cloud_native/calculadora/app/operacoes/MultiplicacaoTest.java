package com.github.rafaritter44.cloud_native.calculadora.app.operacoes;

import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplicacaoTest {

    @Test
    public void calcular() {
        Operacao operacao = new Multiplicacao(10D, 5D);
        assertEquals(50D, (double) operacao.calcular().get(), 0D);
    }

}