package database;

import com.netflix.hystrix.HystrixCommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseCommand extends HystrixCommand<String> {


    public DataBaseCommand(Setter config) {
        super(config);
    }

    @Override
    protected String run() throws Exception {

        StringBuffer sb = new StringBuffer();
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String lastName = rs.getString("nome");
                sb.append(lastName + "\n");
            }
        } catch (Exception exception) {
            throw exception;
        }
        return sb.toString();
    }


    @Override
    protected String getFallback() {
        return "Hello Failure !";
    }
}
