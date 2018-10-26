package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato")) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String lastName = rs.getString("nome");
                System.out.println(lastName + "\n");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}