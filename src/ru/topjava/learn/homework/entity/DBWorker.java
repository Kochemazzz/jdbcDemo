package ru.topjava.learn.homework.entity;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private final String HOST = "jdbc:mysql://localhost:3306/clients?";
    private final String USERNAME = "root";
    private final String PASSWORD = "roor";
    @Getter  Connection connection = null;
    public DBWorker(){
        try {
            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
