package com.github.rafaritter44.cloud_native.calculadora.config;

import com.github.rafaritter44.cloud_native.calculadora.model.*;
import com.github.rafaritter44.cloud_native.calculadora.model.operacoes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.github.rafaritter44.cloud_native.calculadora")
public class AppConfig {

    @Bean
    public Operacao soma() {
        Operacao soma = new Soma();
        ((Soma) soma).setPrimeiroOperando(1D);
        ((Soma) soma).setSegundoOperando(2D);
        return soma;
    }

    @Bean
    public Operacao subtracao() {
        Operacao subtracao = new Subtracao();
        ((Subtracao) subtracao).setPrimeiroOperando(3D);
        ((Subtracao) subtracao).setSegundoOperando(1.5);
        return subtracao;
    }

    @Bean
    public Operacao multiplicacao() {
        Operacao multiplicacao = new Multiplicacao();
        ((Multiplicacao) multiplicacao).setPrimeiroOperando(2D);
        ((Multiplicacao) multiplicacao).setSegundoOperando(4D);
        return multiplicacao;
    }

    @Bean
    public Operacao divisao() {
        Operacao divisao = new Divisao();
        ((Divisao) divisao).setPrimeiroOperando(2D);
        ((Divisao) divisao).setSegundoOperando(0D);
        return divisao;
    }

    @Bean
    public Operacao potencia() {
        Operacao potencia = new Potencia();
        ((Potencia) potencia).setPrimeiroOperando(2D);
        ((Potencia) potencia).setSegundoOperando(10D);
        return potencia;
    }

}
