package ru.topjava.learn.jdbcdemo;

import java.sql.*;

public class PostgreSQLUpdate {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            //регистрация драйвера
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/clients?company",
                            "root",
                            "roor");
            c.setAutoCommit(false);
            System.out.println("Opened DB successfully");
            stmt = c.createStatement();
            String sql = "UPDATE company SET SALARY = 30000 WHERE id = 1";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM company;");
            while(rs.next()){
                int id = rs.getInt("id"); // 1, 2, 3...
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String address = rs.getString(4);
                double salary = rs.getDouble(5);
                System.out.print(id + " " + " " + name + " " + age + " " + address + " " + salary);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done successfully");

    }

}
