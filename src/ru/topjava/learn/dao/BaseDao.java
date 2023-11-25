package ru.topjava.learn.dao;

import ru.topjava.learn.entiny.Entity;
import ru.topjava.learn.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface BaseDao<K, T extends Entity> {
    List<T> findAll() throws DaoException;

    Optional<T>findById(K id) throws DaoException;

    void update(T entity) throws DaoException;

    T save(T entity) throws DaoException;

    boolean delete(K id) throws DaoException;


}
