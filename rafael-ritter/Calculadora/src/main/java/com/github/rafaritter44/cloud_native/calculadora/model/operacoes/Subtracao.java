package com.github.rafaritter44.cloud_native.calculadora.model.operacoes;

import com.github.rafaritter44.cloud_native.calculadora.model.Calculadora;
import com.github.rafaritter44.cloud_native.calculadora.model.Operacao;

public class Subtracao implements Operacao {

    private Calculadora calculadora;

    public Subtracao() {
        calculadora = new Calculadora();
    }

    public void setPrimeiroOperando(double primeiroOperando) {
        calculadora.setPrimeiroOperando(primeiroOperando);
    }

    public void setSegundoOperando(double segundoOperando) {
        calculadora.setSegundoOperando(segundoOperando);
    }

    @Override
    public String operar() { return calculadora.subtracao(); }

}