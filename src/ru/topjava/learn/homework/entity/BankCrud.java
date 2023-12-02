package ru.topjava.learn.homework.entity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankCrud implements BankDao{
    @Override
    public void createTable() {
        String sql = "CREATE TABLE persons_bank " +
                "(personID INT NOT NULL PRIMARY KEY," +
                "name VARCHAR(50)," +
                " surname VARCHAR(50)," +
                " balance float)";
        DBWorker dbWorker = new DBWorker();
        try (Connection connection = dbWorker.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sql);
            connection.commit();
            System.out.println("Table is created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bank> readAll() {
        String sql = "SELECT * FROM persons_bank";
        List<Bank> banks = new ArrayList<>();
        DBWorker dbWorker = new DBWorker();
        try (Connection connection = dbWorker.getConnection(); Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Bank bank = new Bank();
                bank.setId(resultSet.getInt(1));
                bank.setName(resultSet.getString(2));
                bank.setSurname(resultSet.getString(3));
                bank.setMoney(resultSet.getDouble(4));
                banks.add(bank);
                System.out.print(resultSet.getInt(1) + " ");
                System.out.print(resultSet.getString(2) + " ");
                System.out.print(resultSet.getString(3) + " ");
                System.out.print(resultSet.getDouble(4) + " ");
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return banks;
    }
    @Override
    public void updateEntry(int id, String name, String surname, double balance) {

        String sql = "UPDATE persons_bank SET  name = '" + name + "', surname ='" + surname + "', balance = '" + balance + "' " +
                "WHERE personID = '" + id + "'";
        DBWorker dbWorker = new DBWorker();
        try (Connection connection = dbWorker.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Entry UPDATED");
    }
    @Override
    public void deleteEntry(int id) {
        System.out.println("Welcome to delete operation");
        String sql = "DELETE FROM persons_bank WHERE personID =  '" + id + "'";
        DBWorker dbWorker = new DBWorker();
        try (Connection connection = dbWorker.getConnection(); Statement stmt = connection.createStatement()) {
            int i = stmt.executeUpdate(sql);
            connection.commit();
            System.out.println("Done! Delete objects:" + i);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    @Override
    public void insertEntry(int id, String name, String surname, double balance) {

        String sql = "insert into persons_bank(personID,name,surname, balance) " +
                "values('" + id + "','" + name + "','" + surname + "','" + balance + "')";
        DBWorker dbWorker = new DBWorker();
        try (Connection connection = dbWorker.getConnection(); Statement stmt = connection.createStatement()) {
            if (!connection.isClosed()) {
                System.out.println("Connection is ready!");
            }
            connection.setAutoCommit(false);
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
            System.out.println("User is created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
