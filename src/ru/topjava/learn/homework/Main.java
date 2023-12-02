package ru.topjava.learn.homework;
import ru.topjava.learn.homework.entity.BankCrud;



public class Main {
    public static void main(String[] args) {

//        MySQLCreate.createTable();
//        MySQLInsert.insertEntry();
//        MySQLInsert.insertEntry();
//        MySQLUpdate.updateEntry();
//        MySQLDelete.deleteEntry();
//        MySQLRead.readTable();
        BankCrud bankCrud = new BankCrud();
//        bankCrud.createTable();
        bankCrud.insertEntry(1,"Ivan","Ivanov",1221.2131);
        bankCrud.insertEntry(2,"Nikolay","Nikolaev",13131.22);
        bankCrud.updateEntry(1,"Fredy","Kruger",0);
//        List<Bank> banks  = bankCrud.readAll();
//        for (Bank bank : banks) {
//            System.out.println(bank);
//        }
//        bankCrud.deleteEntry(1);


    }
}
