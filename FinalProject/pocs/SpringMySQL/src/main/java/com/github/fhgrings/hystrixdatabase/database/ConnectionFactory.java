package com.github.fhgrings.hystrixdatabase.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/music?useSSL=false";
    private static final String USUARIO = "root";
    private static final String SENHA = "test";

    public static Connection getConnection() {
        System.out.println("Conectando ao banco...");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception exception) {
            throw new RuntimeException("Erro na conexao: ", exception);
        }
    }
}
