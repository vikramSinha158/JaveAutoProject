package com.ct.practice.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ct.practice.utils.DatabaseConnection.ConnectionType;

public final class QueryExecutor {

    private static final Logger LOGGER = LogManager
            .getLogger(QueryExecutor.class.getName());
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public static interface ResultHandler<T> {
        T handle(ResultSet resultSet) throws SQLException;
    }

    private void setArgs(final PreparedStatement preparedStatement,
            final Object... args) throws SQLException {

        if (null != args) {
            int i = 1;
            for (Object arg : args) {
                LOGGER.debug("Arg [" + i + "]: " + arg);
                if (arg instanceof java.sql.Date) {
                    preparedStatement.setDate(i, (java.sql.Date) arg);
                } else if (arg instanceof java.util.Date) {
                    preparedStatement.setTimestamp(i, new Timestamp(
                            ((java.util.Date) arg).getTime()));
                } else {
                    preparedStatement.setObject(i, arg);
                }
                i++;
            }
        }
    }

    /**
     * It is used for executing query which returns multiple columns and rows
     * 
     * @param connectionType
     * @param handler
     * @param query
     * @param args
     * @return
     * @throws Exception
     */
    public <T> List<T> executeQuery(final ConnectionType connectionType,
            final ResultHandler<T> handler, final String query,
            final Object... args) throws Exception {

        final DatabaseConnection databaseConnection = DatabaseConnection
                .getInstance();

        connection = databaseConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            setArgs(preparedStatement, args);
            resultSet = preparedStatement.executeQuery();
            final List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(handler.handle(resultSet));
            }
            return result;
        } finally {
            databaseConnection.close(resultSet);
            databaseConnection.close(preparedStatement);
            databaseConnection.close(connection);
        }
    }

    /**
     * It is used for executing query which returns single column and row
     * 
     * @param connectionType
     * @param handler
     * @param query
     * @param args
     * @return
     * @throws Exception
     */
    public <T> T executeScalarQuery(final ConnectionType connectionType,
            final ResultHandler<T> handler, final String query,
            final Object... args) throws Exception {

        final DatabaseConnection databaseConnection = DatabaseConnection
                .getInstance();

        connection = databaseConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            setArgs(preparedStatement, args);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return handler.handle(resultSet);
            }
            return null;
        } finally {
            databaseConnection.close(resultSet);
            databaseConnection.close(preparedStatement);
            databaseConnection.close(connection);
        }
    }

    /**
     * It is used for executing create, update or delete queries
     * 
     * @param connectionType
     * @param query
     * @param args
     * @throws Exception
     */
    public void executeUpdateQuery(final ConnectionType connectionType,
            final String query, final Object... args) throws Exception {

        final DatabaseConnection databaseConnection = DatabaseConnection
                .getInstance();

        connection = databaseConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            setArgs(preparedStatement, args);
            preparedStatement.executeUpdate();

        } finally {
            databaseConnection.close(resultSet);
            databaseConnection.close(preparedStatement);
            databaseConnection.close(connection);
        }
    }

    /**
     * It is used for executing query which returns multiple rows but we want to
     * verify only certain rows
     * 
     * @param connectionType
     * @param handler
     * @param query
     * @param limit
     * @param args
     * @return
     * @throws Exception
     */
    public <T> List<T> executeQueryWithResultSize(
            final ConnectionType connectionType,
            final ResultHandler<T> handler, final String query,
            final Integer limit, final Object... args) throws Exception {

        final DatabaseConnection databaseConnection = DatabaseConnection
                .getInstance();

        connection = databaseConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            setArgs(preparedStatement, args);
            preparedStatement.setMaxRows(limit);
            resultSet = preparedStatement.executeQuery();
            final List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(handler.handle(resultSet));
            }
            return result;
        } finally {
            databaseConnection.close(resultSet);
            databaseConnection.close(preparedStatement);
            databaseConnection.close(connection);
        }
    }
}
