package ru.topjava.learn.homework;
import ru.topjava.learn.homework.entity.DBWorker;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class MySQLCreate {
    public static void main(String[] args) {
        createTable();
    }
    public static void createTable() {
        String sql = "CREATE TABLE persons_bank " +
                "(personID INT NOT NULL PRIMARY KEY," +
                "name VARCHAR(50)," +
                " surname VARCHAR(50)," +
                " balance float)";
        DBWorker dbWorker = new DBWorker();
        try (Connection connection = dbWorker.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sql);
            connection.commit();
            System.out.println("Table is created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
