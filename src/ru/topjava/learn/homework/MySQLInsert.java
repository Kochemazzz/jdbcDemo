package ru.topjava.learn.homework;
import java.sql.*;
import java.util.Scanner;
public class MySQLInsert {
    public static void main(String[] args) {
        insert();
    }

    public static void insert(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter ID");
        int id = scanner.nextInt();
        System.out.println("please enter NAME");
        String name = scanner.next();
        System.out.println("please enter AGE");
        int age = scanner.nextInt();
        System.out.println("please enter ADDRESS");
        String address = scanner.next();
        System.out.println("please enter SALARY");
        int salary = scanner.nextInt();
        String sql = "insert into company(ID,NAME,AGE, ADDRESS,SALARY) " +
                "values('" + id + "','" + name + "','" + age + "','" + address + "','" + salary + "')";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clients?",
                "root", "roor"); Statement stmt = connection.createStatement();) {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            if (!connection.isClosed()) {
                System.out.println("Connection is ready!");
            }
//            connection.setAutoCommit(false); ask
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
