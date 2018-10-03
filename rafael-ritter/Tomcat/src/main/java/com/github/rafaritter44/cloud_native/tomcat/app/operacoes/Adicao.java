package com.github.rafaritter44.cloud_native.tomcat.app.operacoes;

public class Adicao implements Operacao {

    private double primeiroOperando;
    private double segundoOperando;

    public Adicao(double primeiroOperando, double segundoOperando) {
        this.primeiroOperando = primeiroOperando;
        this.segundoOperando = segundoOperando;
    }

    public double calcular() {
        return primeiroOperando + segundoOperando;
    }

}
