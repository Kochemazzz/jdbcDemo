package ru.topjava.learn.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLInsert {
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
            String sql = "INSERT INTO company (ID, NAME, AGE, ADDRESS, SALARY)" +
                    "VALUES (1, 'Ivan', 30, 'Kazan', 10000)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO company (ID, NAME, AGE, ADDRESS, SALARY)" +
                    "VALUES (2, 'Mariya', 28, 'Moscow', 20000)";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Record inserted successfully");

    }

}


//   sql1, sql2, sql3 -> rs => salary < 0 -> c.rollback() DB_state = 1
//    V     V     s < 0 -> DB_state = 2
//    X   <-  X   <-  X - DB_state = 1
