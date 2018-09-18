package com.github.rafaritter44.cloud_native.calculadora.model;

public class Calculadora {

    private double primeiroOperando;
    private double segundoOperando;

    public Calculadora(){}

    public String soma() {
        return operacaoString('+') + (primeiroOperando + segundoOperando);
    }

    public String subtracao() {
        return operacaoString('-') + (primeiroOperando - segundoOperando);
    }

    public String multiplicacao() {
        return operacaoString('*') + (primeiroOperando * segundoOperando);
    }

    public String divisao() throws ArithmeticException {
        if(segundoOperando == 0D)
            throw new ArithmeticException("Não é possível dividir por zero");
        return operacaoString('/') + (primeiroOperando / segundoOperando);
    }

    public String potencia() {
        return operacaoString('^') + (Math.pow(primeiroOperando, segundoOperando));
    }

    private String operacaoString(char simbolo) {
        return primeiroOperando + " " + simbolo + " " + segundoOperando + " = ";
    }

    public double getPrimeiroOperando() { return primeiroOperando; }
    public void setPrimeiroOperando(double primeiroOperando) { this.primeiroOperando = primeiroOperando; }
    public double getSegundoOperando() { return segundoOperando; }
    public void setSegundoOperando(double segundoOperando) { this.segundoOperando = segundoOperando; }
}
