package ru.topjava.learn.dao.impl;

import ru.topjava.learn.dao.AbonentDao;
import ru.topjava.learn.entiny.Abonent;
import ru.topjava.learn.exceptions.DaoException;
import ru.topjava.learn.util.ConnectionCreator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AbonentDaoImpl implements AbonentDao {
    private static final AbonentDaoImpl INSTANCE = new AbonentDaoImpl();

    private static final String DELETE_SQL = "DELETE FROM phonebook WHERE id_phonebook = ?";

    private static final String SAVE_SQL = "INSERT INTO phonebook (last_name, phone) " +
            "VALUES (?, ?)";

    private static final String UPDATE_SQL = "UPDATE phonebook " +
            "SET last_name = ?, " +
            "phone= ?" +
            "WHERE id_phonebook = ?";

    private static final String FIND_ALL_SQL = "SELECT id_phonebook, last_name, phone FROM phonebook";

    private static final String FIND_BY_ID_SQL = "SELECT id_phonebook, last_name, phone FROM phonebook WHERE id_phonebook = ?";

    private static final String FIND_BY_NAME_SQL = "SELECT * FROM phonebook WHERE last_name = ?";


    public AbonentDaoImpl() {
    }


    @Override
    public List<Abonent> findAll() throws DaoException {
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Abonent> abonents = new ArrayList<>();
            while (resultSet.next()) {
                abonents.add(buildAbonent(resultSet)); // abonents.add(new Abonent(rs.getInt("id_phonebook",...
            }
            return abonents;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public Optional<Abonent> findById(Integer id) throws DaoException { // NPE
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setInt(1, id); // WHERE id_phonebook = ? <- 1
            ResultSet resultSet = preparedStatement.executeQuery();
            Abonent abonent = null;
            if (resultSet.next()) { // не пустой результат выборки по айди
                abonent = buildAbonent(resultSet); // парсинг из строки таблицы результатов
            }
            return Optional.ofNullable(abonent);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Abonent save(Abonent abonent) throws DaoException {
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            //preparedStatement.setInt(1, abonent.getId()); //Java object <- db -  sequence
            preparedStatement.setString(1, abonent.getName()); //   db <- "Ivan"
            preparedStatement.setInt(2, abonent.getPhone()); //  db <- 12334566
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                abonent.setId(generatedKeys.getInt("id_phonebook")); //Java object <- db -  sequence
            }
            return abonent;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Abonent abonent) throws DaoException {
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, abonent.getName()); // name = last_name
            preparedStatement.setInt(2, abonent.getPhone());
            preparedStatement.setInt(3, abonent.getId()); // where id = ?
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0; // при нуле изменений в бд не произошло

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Abonent> findByName(String name) throws DaoException {
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME_SQL)) {
            preparedStatement.setString(1, name); // WHERE id_phonebook = ? <- 1
            ResultSet resultSet = preparedStatement.executeQuery();
            Abonent abonent = null;
            if (resultSet.next()) { // не пустой результат выборки по айди
                abonent = buildAbonent(resultSet); // парсинг из строки таблицы результатов
            }
            return Optional.ofNullable(abonent); //Optional<null>;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static AbonentDaoImpl getInstance() {
        return INSTANCE;
    }

    private Abonent buildAbonent(ResultSet resultSet) throws SQLException {
        return new Abonent(
                resultSet.getInt("id_phonebook"),
                resultSet.getString("last_name"),
                resultSet.getInt("phone")
        );
    }
}
