package ru.topjava.learn.dao;

import ru.topjava.learn.entiny.Abonent;
import ru.topjava.learn.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface AbonentDao extends BaseDao<Integer, Abonent>{
    @Override
    List<Abonent> findAll() throws DaoException;

    @Override
    Optional<Abonent> findById(Integer id) throws DaoException;

    @Override
    Abonent save(Abonent entity) throws DaoException;

    @Override
    void update(Abonent entity) throws DaoException;

    @Override
    boolean delete(Integer id) throws DaoException;

    Optional<Abonent> findByName(String name) throws DaoException;

}
