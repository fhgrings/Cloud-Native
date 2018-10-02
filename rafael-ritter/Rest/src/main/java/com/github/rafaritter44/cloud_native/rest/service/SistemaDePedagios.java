package com.github.rafaritter44.cloud_native.rest.service;

import com.github.rafaritter44.cloud_native.rest.model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SistemaDePedagios {

    public static final float TAXA_POR_EIXO = 1F;

    private SistemaDePedagios() {}

    public static Optional<Float> pagar(Veiculo veiculo, float pagamento, int eixos) {
        float troco = pagamento - (veiculo.getPrecoPadrao() + eixos * TAXA_POR_EIXO);
        return troco < 0 ? Optional.empty() : Optional.ofNullable(troco);
    }

    public static List<String> precos() {
        List<String> precos = new ArrayList<>();
        for(Veiculo veiculo: Veiculo.values())
            precos.add(veiculo.toString());
        return precos;
    }

}
