package ru.topjava.learn.homework;
import ru.topjava.learn.homework.entity.DBWorker;

import java.sql.*;
import java.util.Scanner;
public class MySQLDelete {
    public static void main(String[] args) {
        deleteEntry();
    }
    public static void deleteEntry() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to delete operation");
        System.out.println("Please, enter ID");
        int id = scan.nextInt();
        System.out.println("Please, enter name");
        String namePerson = scan.next();
        String sql = "DELETE FROM persons_bank WHERE personID =  '" + id + "' OR name = '" + namePerson + "'";
        DBWorker dbWorker = new DBWorker();
        try (Connection connection = dbWorker.getConnection(); Statement stmt = connection.createStatement()) {
            connection.setAutoCommit(true);
            int i = stmt.executeUpdate(sql);
            connection.commit();
            System.out.println("Done! Delete objects:" + i);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
