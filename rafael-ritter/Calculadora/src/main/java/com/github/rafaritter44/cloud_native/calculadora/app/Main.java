package com.github.rafaritter44.cloud_native.calculadora.app;

import com.github.rafaritter44.cloud_native.calculadora.config.AppConfig;
import com.github.rafaritter44.cloud_native.calculadora.model.Operacao;
import com.github.rafaritter44.cloud_native.calculadora.service.GerenciadorDeOperacoes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String args[]) {
        ApplicationContext contextoDeAplicacao = new AnnotationConfigApplicationContext(AppConfig.class);
        GerenciadorDeOperacoes gerenciador = new GerenciadorDeOperacoes();
        gerenciador.addOperacao((Operacao) contextoDeAplicacao.getBean("soma"));
        gerenciador.addOperacao((Operacao) contextoDeAplicacao.getBean("subtracao"));
        gerenciador.addOperacao((Operacao) contextoDeAplicacao.getBean("multiplicacao"));
        gerenciador.addOperacao((Operacao) contextoDeAplicacao.getBean("divisao"));
        gerenciador.addOperacao((Operacao) contextoDeAplicacao.getBean("potencia"));
        gerenciador.executaOperacoes();
        ((AnnotationConfigApplicationContext)contextoDeAplicacao).close();
    }

}
