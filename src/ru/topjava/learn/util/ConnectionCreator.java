package ru.topjava.learn.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static final Properties properties = new Properties();
    private static final String DATABASE_URL;

    static {
        try {
            properties.load(new FileInputStream(String.valueOf(Path.of("datares","database.properties"))));

            //properties.setProperty("escapeSyntaxCallMode", "callIfNoReturn");
            String driverName = (String) properties.get("db.driver");
            Class.forName(driverName);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        DATABASE_URL = (String) properties.get("db.url");
    }

    private ConnectionCreator() {
    }

    public static Connection createConnection(){
        try {
            return DriverManager.getConnection(DATABASE_URL, properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
