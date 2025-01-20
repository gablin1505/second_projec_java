package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema2", "root", "Allo0791#$"); // ту верните свои данные
    }
    public static void main(String[] args) {
        try (Connection connection = Util.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Соединение с базой данных установлено успешно!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
