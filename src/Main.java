//outra forma de conectar com o db no mysql

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_schema",
                    "root",
                    "12345678"
            );

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");

            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}