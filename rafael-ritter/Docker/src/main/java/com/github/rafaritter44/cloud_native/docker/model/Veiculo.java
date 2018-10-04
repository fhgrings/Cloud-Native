package com.github.rafaritter44.cloud_native.docker.model;

public enum Veiculo {

    ONIBUS(1.59F),
    MOTO(1F),
    BIKE(0.49F),
    CAMINHAO(3.95F),
    FUSCA(2.11F);

    private float precoPadrao;

    Veiculo(float precoPadrao) {
        this.precoPadrao = precoPadrao;
    }

    public float getPrecoPadrao() {
        return precoPadrao;
    }

    @Override
    public String toString() {
        return this.name() + " | " + precoPadrao;
    }

}
