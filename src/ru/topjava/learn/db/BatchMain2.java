package ru.topjava.learn.db;

import ru.topjava.learn.entiny.Abonent;
import ru.topjava.learn.util.ConnectionCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BatchMain2 {
    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.createConnection()) {

            List<Abonent>abonents = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO phonebook VALUES (?, ?, ?)");
            for(Abonent abonent:abonents){
                statement.setInt(1,abonent.getId());
                statement.setString(2,abonent.getName());
                statement.setInt(3,abonent.getPhone());
                statement.addBatch();
            }
            int[]updatedCounts = statement.executeBatch();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


