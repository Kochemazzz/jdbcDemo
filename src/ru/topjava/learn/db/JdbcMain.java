package ru.topjava.learn.db;

import ru.topjava.learn.util.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain {
    public static void main(String[] args) {
        try(Connection connection = ConnectionCreator.createConnection();
            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
            ResultSet resultSet =
                    statement.executeQuery(
                            "SELECT id_phonebook, last_name, phone " +
                                    "FROM phonebook");
            resultSet.moveToInsertRow();
            //resultSet.updateInt(1, 102);
            resultSet.updateString(2, "Ivanova");
            resultSet.updateInt(3, 333333333);
            resultSet.insertRow();
            resultSet.moveToCurrentRow();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
