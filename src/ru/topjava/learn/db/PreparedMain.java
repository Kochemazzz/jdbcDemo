package ru.topjava.learn.db;

import ru.topjava.learn.util.ConnectionCreator;

import java.sql.*;

public class PreparedMain {
    public static void main(String[] args) {
        try(Connection connection = ConnectionCreator.createConnection()) {
            String sql = "INSERT INTO phonebook (last_name, phone) VALUES (?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "Sidorova");
            preparedStatement.setInt(2, 555555555);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                int key = resultSet.getInt(1);
                System.out.println("id_phonebook of Sidorova:  " + key);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
