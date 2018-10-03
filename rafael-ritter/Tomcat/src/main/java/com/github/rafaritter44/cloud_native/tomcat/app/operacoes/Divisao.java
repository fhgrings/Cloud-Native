package com.github.rafaritter44.cloud_native.tomcat.app.operacoes;

public class Divisao implements Operacao {

    private double primeiroOperando;
    private double segundoOperando;

    public Divisao(double primeiroOperando, double segundoOperando) {
        this.primeiroOperando = primeiroOperando;
        this.segundoOperando = segundoOperando;
    }

    public double calcular() {
        if(segundoOperando == 0D)
            throw new ArithmeticException("Não é possível dividir por zero");
        return primeiroOperando / segundoOperando;
    }

}