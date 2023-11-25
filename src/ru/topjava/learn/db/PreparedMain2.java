package ru.topjava.learn.db;

import ru.topjava.learn.util.ConnectionCreator;

import java.sql.*;

public class PreparedMain2 {
    public static void main(String[] args) {
        try(Connection connection = ConnectionCreator.createConnection()) {
            String sql = "INSERT INTO phonebook (lastname, phone) VALUES (?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            //preparedStatement.setInt(1, 333);
            preparedStatement.setString(1, "Yagudin");
            preparedStatement.setInt(2, 755555555);
            int rows = preparedStatement.executeUpdate();

            System.out.println(rows);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
