package ru.topjava.learn.db;

import ru.topjava.learn.util.ConnectionCreator;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableMain {
    public static void main(String[] args) {

        final String SQL = "{call display_msg(?)}";
        try(Connection connection = ConnectionCreator.createConnection();
            CallableStatement statement = connection.prepareCall(SQL)){
            connection.setAutoCommit(true);

            statement.registerOutParameter(1, Types.VARCHAR);
            statement.setString(1, "Hello, Topjava!");
            statement.execute();
            String result = statement.getString(1);
            System.out.println(result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
