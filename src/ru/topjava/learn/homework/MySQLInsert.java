package ru.topjava.learn.homework;
import ru.topjava.learn.homework.entity.DBWorker;

import java.sql.*;
import java.util.Scanner;
public class MySQLInsert {
    public static void main(String[] args) {
        insertEntry();
    }
    public static void insertEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter ID");
        int id = scanner.nextInt();
        System.out.println("please enter NAME");
        String name = scanner.next();
        System.out.println("please enter SURNAME");
        String surname = scanner.next();
        System.out.println("please enter BALANCE");
        double balance = scanner.nextDouble();
        String sql = "insert into persons_bank(personID,name,surname, balance) " +
                "values('" + id + "','" + name + "','" + surname + "','" + balance + "')";
        DBWorker dbWorker = new DBWorker();
        try (Connection connection = dbWorker.getConnection(); Statement stmt = connection.createStatement()) {
            if (!connection.isClosed()) {
                System.out.println("Connection is ready!");
            }
            connection.setAutoCommit(false);
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
