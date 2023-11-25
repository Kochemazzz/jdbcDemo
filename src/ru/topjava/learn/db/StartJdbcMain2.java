package ru.topjava.learn.db;

import org.postgresql.Driver;
import ru.topjava.learn.entiny.Abonent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StartJdbcMain2 {
    public static void main(String[] args)  {
        try {
            DriverManager.registerDriver(new Driver());
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
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
            //String sql = "SELECT idphonebook, lastname, phone FROM phonebook";

            ResultSet resultSet = statement.executeQuery("SELECT id_phonebook, last_name, phone FROM phonebook");

            /*
            resultSet.moveToInsertRow();
            resultSet.updateInt(1, 1111);
            resultSet.updateString(2, "Valeeva");
            resultSet.updateInt(3, 788888887);
            resultSet.insertRow();
            resultSet.moveToCurrentRow();

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                if(id == 3){
                    resultSet.updateInt("phone", 999999999);
                    resultSet.updateRow();
                }

            }


             */



            System.out.println("---------------------------------------------------");

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.println("ColumnCount" + resultSetMetaData.getColumnCount());
            System.out.println("ColumnName" + resultSetMetaData.getColumnName(1));
            System.out.println("ColumnTypeName" + resultSetMetaData.getColumnTypeName(1));
            System.out.println("isAutoIncrement" + resultSetMetaData.isAutoIncrement(1));
            System.out.println("column name" + resultSetMetaData.getColumnName(2));
            System.out.println("ColumnTypeName" + resultSetMetaData.getColumnTypeName(2));
            System.out.println("isAutoIncrement" + resultSetMetaData.isAutoIncrement(2));


            System.out.println("DB Product" + databaseMetaData.getDatabaseProductName());
            System.out.println("getDatabaseMajorVersion" + databaseMetaData.getDatabaseMajorVersion());
            System.out.println("UserName" + databaseMetaData.getUserName());
            System.out.println("Transaction Isolation " + databaseMetaData.getDefaultTransactionIsolation());
            System.out.println("Transaction Isolation supported " + databaseMetaData.supportsTransactionIsolationLevel(1));
            System.out.println("URL" + databaseMetaData.getURL());






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
