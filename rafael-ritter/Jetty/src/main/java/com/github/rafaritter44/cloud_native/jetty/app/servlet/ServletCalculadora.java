package com.github.rafaritter44.cloud_native.jetty.app.servlet;

import com.github.rafaritter44.cloud_native.jetty.app.Calculadora;
import com.github.rafaritter44.cloud_native.jetty.app.CalculadoraSingleton;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(value="/calculadora", name ="ServletCalculadora")
public class ServletCalculadora extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Calculadora calculadora = CalculadoraSingleton.getInstance();
        double primeiroOperando = Double.parseDouble(request.getParameter("primeiroOperando"));
        double segundoOperando = Double.parseDouble(request.getParameter("segundoOperando"));
        char operador = request.getParameter("operador").charAt(0);
        PrintWriter saida = response.getWriter();
        Optional<Double> calculo = Optional.empty();
        try {
            calculo = calculadora.calcular(primeiroOperando, operador, segundoOperando);
        } catch(ReflectiveOperationException excecao) {
            saida.println(excecao.getMessage());
            return;
        }
        saida.println(calculo.isPresent()? calculo.get(): "Não é possível dividir por zero");
    }

}
