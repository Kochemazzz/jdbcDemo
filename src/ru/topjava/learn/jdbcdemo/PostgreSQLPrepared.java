package ru.topjava.learn.jdbcdemo;

import ru.topjava.learn.util.ConnectionCreator;

import java.sql.*;

public class PostgreSQLPrepared {
    public static void main(String[] args) {

        String sql = "INSERT INTO company (id, name, age, address, salary) VALUES (?, ?, ?, ?, ?);";
        try(Connection connection = ConnectionCreator.createConnection()){

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 33);
            stmt.setString(2, "Volodya");
            stmt.setInt(3, 33);
            stmt.setString(4, "SPb");
            stmt.setDouble(5, 100000.00);
            int rows = stmt.executeUpdate();
            System.out.println(rows);

/*
            ResultSet rs = stmt.executeQuery("SELECT * FROM company;");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String address = rs.getString(4);
                double salary = rs.getDouble(5);
                System.out.print(id + " " + " " + name + " " + age + " " + address + " " + salary);
                System.out.println();
            }

 */
            //rs.close();
            stmt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done successfully");

    }

}
