import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "anmol";
    private static final String DB_NAME = "java_database";

    public static void main(String[] args) {
        String sql = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Database '" + DB_NAME + "' created or already exists.");

        } catch (SQLException e) {
            System.err.println("Error creating database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
