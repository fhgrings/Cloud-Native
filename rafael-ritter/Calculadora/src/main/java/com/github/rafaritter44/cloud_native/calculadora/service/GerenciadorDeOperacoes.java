package com.github.rafaritter44.cloud_native.calculadora.service;

import com.github.rafaritter44.cloud_native.calculadora.model.Operacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GerenciadorDeOperacoes {

    private List<Operacao> operacoes;

    public GerenciadorDeOperacoes() {
        operacoes = new ArrayList<>();
    }

    public void addOperacao(Operacao operacao) {
        operacoes.add(operacao);
    }

    public void executaOperacoes() {
        for(Operacao operacao: operacoes)
            System.out.println(operacao.operar());
    }

}
