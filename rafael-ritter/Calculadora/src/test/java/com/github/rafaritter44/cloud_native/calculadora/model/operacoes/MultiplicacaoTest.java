package com.github.rafaritter44.cloud_native.calculadora.model.operacoes;

import com.github.rafaritter44.cloud_native.calculadora.config.AppConfig;
import com.github.rafaritter44.cloud_native.calculadora.model.Operacao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class MultiplicacaoTest {

    @Autowired
    private Operacao multiplicacao;

    @Test
    public void operar() {
        assertEquals("2.0 * 4.0 = 8.0", multiplicacao.operar());
    }
}