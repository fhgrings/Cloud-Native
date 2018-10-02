package com.github.rafaritter44.cloud_native.rest.controller;

import com.github.rafaritter44.cloud_native.rest.messages.Mensagens;
import com.github.rafaritter44.cloud_native.rest.model.Veiculo;
import com.github.rafaritter44.cloud_native.rest.service.SistemaDePedagios;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("pedagios")
public class PedagiosController {

    private final String utf8 = ";charset=utf-8";

    @GET
    @Path("cobrar")
    @Produces(MediaType.TEXT_PLAIN + utf8)
    public String cobrar(@QueryParam("veiculo") String veiculo,
                         @QueryParam("pagamento") float pagamento,
                         @DefaultValue("0") @QueryParam("eixos") int eixos) {
        try {
            return Mensagens.cobranca(SistemaDePedagios.pagar(Veiculo.valueOf(veiculo), pagamento, eixos));
        } catch (IllegalArgumentException excecao) {
            return Mensagens.VEICULO_NAO_ENCONTRADO;
        }
    }

    @GET
    @Path("tabela")
    @Produces(MediaType.TEXT_PLAIN + utf8)
    public String tabela() {
        return Mensagens.tabela(SistemaDePedagios.precos());
    }

}
