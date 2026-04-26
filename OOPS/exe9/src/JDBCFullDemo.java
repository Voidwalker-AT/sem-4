import java.sql.*;

public class JDBCFullDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "anmol";

        try {
            // Connect MySQL
            Connection con =
                DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            // 1. Create Database
            stmt.executeUpdate(
                "CREATE DATABASE IF NOT EXISTS java_database");

            System.out.println("Database Created!");

            // 2. Use Database
            stmt.execute("USE java_database");

            // 3. Create Table
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS student (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "age INT, " +
                "marks INT)"
            );

            System.out.println("Table Created!");

            // 4. Delete existing data to avoid duplicate key errors
            stmt.executeUpdate("DELETE FROM student");

            // 5. Insert Data
            stmt.executeUpdate(
                "INSERT INTO student VALUES (1,'Anmol',20,88)");

            stmt.executeUpdate(
                "INSERT INTO student VALUES (2,'Rahul',20,85)");

            stmt.executeUpdate(
                "INSERT INTO student VALUES (3,'Sneha',22,92)");

            System.out.println("Data Inserted!");

            // 6. Retrieve Data
            ResultSet rs =
                stmt.executeQuery("SELECT * FROM student");

            System.out.println("\nStudent Records:");

            while(rs.next()) {

                System.out.println(
                    rs.getInt("id") + "  " +
                    rs.getString("name") + "  " +
                    rs.getString("age") + "  " +
                    rs.getInt("marks")
                );
            }

            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}