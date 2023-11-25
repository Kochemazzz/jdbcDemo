package ru.topjava.learn.db;

import ru.topjava.learn.dao.impl.AbonentDaoImpl;
import ru.topjava.learn.entiny.Abonent;
import ru.topjava.learn.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public class DaoMain {
    public static void main(String[] args) throws DaoException {
        //List<Abonent>abonents = AbonentDaoImpl.getInstance().findAll();
        //System.out.println(abonents);

        //saveMain();

        //updateMain();

        deleteMain(19);



        //TODO:в main проверить работу CrUD и сделать для сущности Location

    }

    private static void updateMain() throws DaoException {
        AbonentDaoImpl abonentDao = AbonentDaoImpl.getInstance();

        Optional<Abonent>abonentForUpdate = abonentDao.findById(19);
        System.out.println(abonentForUpdate);

        abonentForUpdate.ifPresent(abonent -> {
            abonent.setPhone(99999999);
            try {
                abonentDao.update(abonent);
            } catch (DaoException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(abonentDao.findAll());

    }

    private static void deleteMain(Integer id) throws DaoException {
        AbonentDaoImpl abonentDao = AbonentDaoImpl.getInstance();

        System.out.println("Abonent is deleted?: " + abonentDao.delete(id));
    }

    private static void saveMain() throws DaoException {
        AbonentDaoImpl abonentDao = AbonentDaoImpl.getInstance();

        Abonent abonent = new Abonent();

        //abonent.setId(1000);
        abonent.setName("Vasilisa");
        abonent.setPhone(100000);

        Abonent generatedAbonent = abonentDao.save(abonent);
        System.out.println(generatedAbonent);
    }



}
