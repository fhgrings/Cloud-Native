package com.github.rafaritter44.cloud_native.jetty.app.operacoes;

public class Subtracao implements Operacao {

    private double primeiroOperando;
    private double segundoOperando;

    public Subtracao(double primeiroOperando, double segundoOperando) {
        this.primeiroOperando = primeiroOperando;
        this.segundoOperando = segundoOperando;
    }

    public double calcular() {
        return primeiroOperando - segundoOperando;
    }

}
