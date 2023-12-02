package ru.topjava.learn.homework;
import ru.topjava.learn.homework.entity.DBWorker;

import java.sql.*;
public class MySQLRead {
    public static void main(String[] args) {
        readTable();
    }
    public static void readTable() {
        String sql = "SELECT * FROM persons_bank";
        DBWorker dbWorker = new DBWorker();
        try (Connection connection = dbWorker.getConnection(); Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                System.out.print(resultSet.getInt(1) + " ");
                System.out.print(resultSet.getString(2) + " ");
                System.out.print(resultSet.getString(3) + " ");
                System.out.print(resultSet.getDouble(4) + " ");
                System.out.println();

            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
