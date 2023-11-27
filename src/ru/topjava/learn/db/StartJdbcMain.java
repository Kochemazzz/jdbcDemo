package ru.topjava.learn.db;


import ru.topjava.learn.entiny.Abonent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StartJdbcMain {
    public static void main(String[] args)  {
        try {
            DriverManager.registerDriver((new com.mysql.cj.jdbc.Driver()));
            //Class.forName(org.postgresql.Driver);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties prop = new Properties();
        prop.put("user", "postgres");
        prop.put("password", "postgres");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        prop.put("useSSL", "true");
        prop.put("useJDBCCompliantTimezoneShift", "true");
        prop.put("useLegacyDatetimeCode", "false");
        prop.put("serverTime", "UTC");
        prop.put("serverSslCert", "classpath:server.crt");

        try(Connection connection = DriverManager.getConnection(url, prop);
            Statement statement = connection.createStatement()){
            String sql = "SELECT id_phonebook, last_name, phone FROM public.phonebook";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Abonent> abonents = new ArrayList<>();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int number = resultSet.getInt(3);
                abonents.add(new Abonent(id, name, number));
            }

            System.out.println(abonents);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
