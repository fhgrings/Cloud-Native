package com.github.rafaritter44.cloud_native.jetty.app.servlet;

import com.github.rafaritter44.cloud_native.jetty.app.singleton.AppContextSingleton;
import com.github.rafaritter44.cloud_native.jetty.app.Calculadora;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/calculadora", name ="ServletCalculadora")
public class ServletCalculadora extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Calculadora calculadora = AppContextSingleton.getInstance().getBean(Calculadora.class);
        double primeiroOperando = Double.parseDouble(request.getParameter("primeiroOperando"));
        double segundoOperando = Double.parseDouble(request.getParameter("segundoOperando"));
        char operador = request.getParameter("operador").charAt(0);
        PrintWriter saida = response.getWriter();
        try {
            saida.println(calculadora.calcular(primeiroOperando, operador, segundoOperando));
        } catch(ReflectiveOperationException | ArithmeticException excecao) {
            saida.println(excecao.getMessage());
        }
    }

}
