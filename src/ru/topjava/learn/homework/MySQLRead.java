package ru.topjava.learn.homework;
import java.sql.*;
public class MySQLRead {
    public static void main(String[] args) {
        read();
    }
    public static void read() {
        String sql = "SELECT * FROM company";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clients?", "root", "roor");
             Statement stmt = connection.createStatement();) {
             ResultSet resultSet = stmt.executeQuery(sql);
             while (resultSet.next()){
                 System.out.print(resultSet.getInt(1) +" ");
                 System.out.print(resultSet.getString(2) + " ");
                 System.out.print(resultSet.getInt(3) + " ");
                 System.out.print(resultSet.getString(4) + " ");
                 System.out.print(resultSet.getInt(5)+ " ");
             }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
