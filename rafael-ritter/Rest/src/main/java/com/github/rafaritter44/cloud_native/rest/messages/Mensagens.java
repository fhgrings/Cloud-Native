package com.github.rafaritter44.cloud_native.rest.messages;

import com.github.rafaritter44.cloud_native.rest.service.SistemaDePedagios;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

public class Mensagens {

    public static final String VEICULO_NAO_ENCONTRADO = "O tipo de veículo informado não foi encontrado";

    public static String cobranca(Optional<Float> troco) {
        return troco.isPresent()? "Seu troco: R$" + troco.get(): "Pagamento insuficiente";
    }

    public static String tabela(List<String> precos) {
        StringBuilder builder = new StringBuilder().append("TABELA DE PEDÁGIOS:\n");
        builder.append(precos.stream().collect(joining("\n")));
        return builder.append("\nValor adicional por eixo: ")
                .append(SistemaDePedagios.TAXA_POR_EIXO)
                .toString();
    }

}
