package com.github.rafaritter44.cloud_native.calculadora.app;

import com.github.rafaritter44.cloud_native.calculadora.app.config.AppConfig;
import com.github.rafaritter44.cloud_native.calculadora.app.operacoes.Operacao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CalculadoraTest {

    @Autowired
    private Calculadora calculadora;

    @Test
    public void adicao() throws ReflectiveOperationException {
        assertEquals(3D, (double) calculadora.calcular(1D,'+', 2D).get(), 0D);
    }

    @Test
    public void subtracao() throws ReflectiveOperationException {
        assertEquals(-3D, (double) calculadora.calcular(5D,'-', 8D).get(), 0D);
    }

    @Test
    public void multiplicacao() throws ReflectiveOperationException {
        assertEquals(50D, (double) calculadora.calcular(10D,'*', 5D).get(), 0D);
    }

    @Test
    public void divisao() throws ReflectiveOperationException {
        assertFalse(calculadora.calcular(1D,'/', 0D).isPresent());
        assertFalse(calculadora.calcular(0D,'/', 0D).isPresent());
        assertEquals(10D, (double) calculadora.calcular(20D,'/', 2D).get(), 0D);
    }

    @Test
    public void potencia() throws ReflectiveOperationException {
        assertEquals(1024D, (double) calculadora.calcular(2D,'^', 10D).get(), 0D);
    }

    @Test
    public void getHistorico() throws ReflectiveOperationException {
        calculadora.limparHistorico();
        calculadora.calcular(1D,'+', 2D);
        calculadora.calcular(5D,'-', 8D);
        calculadora.calcular(10D,'*', 5D);
        calculadora.calcular(1D,'/', 0D);
        calculadora.calcular(0D,'/', 0D);
        calculadora.calcular(20D,'/', 2D);
        calculadora.calcular(2D,'^', 10D);
        List<Operacao> operacoes = calculadora.getHistorico();
        assertEquals(3D, operacoes.get(0).calcular().get(), 0D);
        assertEquals(-3D, operacoes.get(1).calcular().get(), 0D);
        assertEquals(50D, operacoes.get(2).calcular().get(), 0D);
        assertFalse(operacoes.get(3).calcular().isPresent());
        assertFalse(operacoes.get(4).calcular().isPresent());
        assertEquals(10D, operacoes.get(5).calcular().get(), 0D);
        assertEquals(1024D, operacoes.get(6).calcular().get(), 0D);

    }
}