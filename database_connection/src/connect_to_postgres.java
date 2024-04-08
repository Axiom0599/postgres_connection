import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.postgresql.jdbc.EscapedFunctions.INSERT;

public class connect_to_postgres {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/registrations";
        String username = "postgres";
        String password = "password";

        try{
            Connection connection= DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connected to PostgreSQL server");

            String sql = "INSERT INTO users VALUES('Jack', 'lkjlksjdlksjd', 'm@mail')";


            Statement statement;
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if (rows>0) {
                System.out.println("A new contatact has been inserted");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connecting to PostgreSQL");
            e.printStackTrace();
        }
    }
}
