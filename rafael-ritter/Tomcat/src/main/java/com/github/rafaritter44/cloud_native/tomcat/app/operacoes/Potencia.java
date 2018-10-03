package com.github.rafaritter44.cloud_native.tomcat.app.operacoes;

import java.util.Optional;

public class Potencia implements Operacao {

    private double primeiroOperando;
    private double segundoOperando;

    public Potencia(double primeiroOperando, double segundoOperando) {
        this.primeiroOperando = primeiroOperando;
        this.segundoOperando = segundoOperando;
    }

    public double calcular() {
        return Math.pow(primeiroOperando, segundoOperando);
    }

}
