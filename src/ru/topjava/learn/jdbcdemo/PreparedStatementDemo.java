package ru.topjava.learn.jdbcdemo;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) {

        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String login = "postgres", password = "postgres";

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection c = DriverManager.getConnection(url, login, password)) {
                c.setAutoCommit(false);
                String sql = "INSERT INTO company (id, age, address, salary) " +
                        "VALUES (?, ?, ?, ?)";
                System.out.println("Opened DB successfully");
                PreparedStatement stmt = c.prepareStatement(sql);
                stmt.setInt(1, 101);
                stmt.setInt(2, 33);
                stmt.setString(3, "SPb");
                stmt.setDouble(4, 100000.00);


                int rows = stmt.executeUpdate();

                System.out.println(rows);
                c.commit();


            } catch (Exception e) {
                System.out.println("SQL failed");
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println("SQL failed");
            System.out.println(e);
        }
    }
}