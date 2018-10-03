package com.github.rafaritter44.cloud_native.tomcat.app.servlet;

import com.github.rafaritter44.cloud_native.tomcat.app.Calculadora;
import com.github.rafaritter44.cloud_native.tomcat.app.AppContextSingleton;
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
        Calculadora calculadora = AppContextSingleton.getInstance().getBean(Calculadora.class);
        PrintWriter saida = response.getWriter();
        for(Operacao operacao: calculadora.getHistorico()) {
            try {
                saida.println(operacao.calcular());
            } catch(ArithmeticException excecao) {
                saida.println(excecao.getMessage());
            }
        }
    }
}
