package ru.topjava.learn.homework;
import ru.topjava.learn.homework.entity.DBWorker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
        String sql = "SELECT * FROM company";
        DBWorker dbWorker = new DBWorker();
        System.out.println("Connection is ready");
        try {
            Connection connection = dbWorker.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
