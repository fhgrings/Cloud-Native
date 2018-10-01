package com.github.rafaritter44.cloud_native.jetty.app.operacoes;

import java.util.Optional;

public class Divisao implements Operacao {

    private double primeiroOperando;
    private double segundoOperando;

    public Divisao(double primeiroOperando, double segundoOperando) {
        this.primeiroOperando = primeiroOperando;
        this.segundoOperando = segundoOperando;
    }

    public Optional<Double> calcular() {
        if(segundoOperando == 0D) {
            System.out.println("Não é possível dividir por zero");
            return Optional.empty();
        }
        return Optional.ofNullable(primeiroOperando / segundoOperando);
    }

}