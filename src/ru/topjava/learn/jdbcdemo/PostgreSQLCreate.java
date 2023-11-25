package ru.topjava.learn.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLCreate {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            //регистрация драйвера
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/clients?",
                            "root",
                            "roor");
            System.out.println("Opened DB successfully");
            stmt = c.createStatement();
            String sql = "CREATE TABLE company (id INT PRIMARY KEY NOT NULL, " +
                    "NAME TEXT NOT NULL," +
                    "AGE INT NOT NULL," +
                    "ADDRESS CHAR(50), " +
                    "SALARY NUMERIC);";

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Table created successfully");

    }

}
