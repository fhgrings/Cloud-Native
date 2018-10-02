package com.github.rafaritter44.cloud_native.calculadora.app.operacoes;

import java.util.Optional;

public interface Operacao {
    Optional<Double> calcular();
}
