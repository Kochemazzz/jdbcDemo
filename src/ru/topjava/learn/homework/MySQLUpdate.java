package ru.topjava.learn.homework;
import ru.topjava.learn.homework.entity.DBWorker;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class MySQLUpdate {
    public static void main(String[] args) {
        updateEntry();
    }

    public static void  updateEntry(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter ID");
        int id = scanner.nextInt();
        System.out.println("please enter NAME");
        String name = scanner.next();
        System.out.println("please enter SURNAME");
        String surname = scanner.next();
        System.out.println("please enter BALANCE");
        double balance = scanner.nextDouble();
        String sql = "UPDATE persons_bank SET  name = '" + name + "', surname ='" + surname + "', balance = '" + balance + "' " +
                "WHERE personID = '" + id + "'";
        DBWorker dbWorker = new DBWorker();
        try (Connection connection = dbWorker.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
