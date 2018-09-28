package com.github.rafaritter44.cloud_native.tomcat.app.servlet;

import com.github.rafaritter44.cloud_native.tomcat.app.Calculadora;
import com.github.rafaritter44.cloud_native.tomcat.app.CalculadoraSingleton;
import com.github.rafaritter44.cloud_native.tomcat.app.operacoes.Operacao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(value="/historico", name ="ServletHistorico")
public class ServletHistorico extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Calculadora calculadora = CalculadoraSingleton.getInstance();
        PrintWriter saida = response.getWriter();
        for(Operacao operacao: calculadora.getHistorico()) {
            Optional<Double> resultado = operacao.calcular();
            saida.println(resultado.isPresent()? resultado.get(): "Usuário tentou dividir por zero");
        }
    }

}
