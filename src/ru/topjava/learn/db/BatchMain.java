package ru.topjava.learn.db;

import ru.topjava.learn.util.ConnectionCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BatchMain {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = ConnectionCreator.createConnection();
            connection.setAutoCommit(false);
            Statement batchStatement = connection.createStatement();
            batchStatement.addBatch("INSERT INTO phonebook (last_name, phone) VALUES ('Zadornov', 555555722);");
            batchStatement.addBatch("INSERT INTO location (city) VALUES ('Moscow');");
            batchStatement.addBatch("INSERT INTO location (city) VALUES ('Kazan');");
            int[] updateCounts = batchStatement.executeBatch();
            System.out.println(Arrays.toString(updateCounts));

            connection.commit();


        } catch (SQLException e) {

                try {
                    if(connection != null) {
                        connection.rollback();
                    }
                } catch (SQLException ex) {
                    System.out.println("Rollback error");
                }
            } finally {

                try {
                    if (connection != null) {
                        connection.setAutoCommit(true);
                    }
                } catch (SQLException e) {
                    System.out.println("SetAutoCommit Error");
                }


                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        System.out.println("Connection Close error");
                    }
                }
        }

    }

