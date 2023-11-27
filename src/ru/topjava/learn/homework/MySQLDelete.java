package ru.topjava.learn.homework;
import java.sql.*;
import java.util.Scanner;
public class MySQLDelete {
    public static void main(String[] args) {
        delete();

    }
    public static void delete() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to delete operation");
        System.out.println("Please, enter ID");
        int id = scan.nextInt();
        System.out.println("Please, enter ADDRESS");
        String address = scan.next();
        String sql = "DELETE FROM company WHERE ID =  '" + id + "' OR ADDRESS = '" + address + "' ";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clients?",
                "root", "roor"); Statement stmt = connection.createStatement();) {

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            int i = stmt.executeUpdate(sql);
            System.out.println("Done! Delete objects:" + i);

        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }
}
