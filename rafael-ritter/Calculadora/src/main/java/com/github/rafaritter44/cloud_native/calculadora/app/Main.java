package com.github.rafaritter44.cloud_native.calculadora.app;

import com.github.rafaritter44.cloud_native.calculadora.app.config.AppConfig;
import com.github.rafaritter44.cloud_native.calculadora.app.operacoes.Operacao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String args[]) throws ReflectiveOperationException {

        ApplicationContext contextoDaAplicacao = new AnnotationConfigApplicationContext(AppConfig.class);

        Calculadora calculadora = (Calculadora) contextoDaAplicacao.getBean("calculadora");

        System.out.println("1 + 2 = " + calculadora.calcular(1D, '+', 2D).get());
        System.out.println("5 - 8 = " + calculadora.calcular(5D, '-', 8D).get());
        System.out.println("10 * 5 = " + calculadora.calcular(10D, '*', 5D).get());
        System.out.println("1 / 0 = " + calculadora.calcular(1D, '/', 0D));
        System.out.println("2 ^ 10 = " + calculadora.calcular(2D, '^', 10D).get());


        List<Operacao> historico = calculadora.getHistorico();

        System.out.println("HISTÓRICO DE RESULTADOS:");
        historico.stream()
                .filter(operacao -> operacao.calcular().isPresent())
                .forEach(operacao -> System.out.println(operacao.calcular().get()));

        ((AnnotationConfigApplicationContext)contextoDaAplicacao).close();
    }

}
