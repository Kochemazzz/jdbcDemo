package ru.topjava.learn.homework.entity;
import java.util.List;
public interface BankDao {
    void createTable();
    List<Bank> readAll();
    void updateEntry(int id, String name, String surname, double balance);
    void deleteEntry(int id);
    void insertEntry(int id, String name, String surname, double balance);
}
