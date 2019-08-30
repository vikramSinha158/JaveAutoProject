package com.ct.practice.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConnection {

    private static final Logger LOGGER = LogManager
            .getLogger(DatabaseConnection.class.getName());
    private static DatabaseConnection databaseConnection;
    private String connectionURL;
    private String username;
    private String password;

    /**
     * 
     * @author ArvindT based on Connection type you can switch the env if
     *         required
     */
    public enum ConnectionType {
        READ, WRITE
    }

    private DatabaseConnection() throws Exception {

        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/config.properties"));

        String drivers = prop.getProperty("jdbc.driver");

        connectionURL = prop.getProperty("jdbc.url");
        username = prop.getProperty("jdbc.userName");
        password = prop.getProperty("jdbc.password");

        Class.forName(drivers);
    }

    public static DatabaseConnection getInstance() throws Exception {
        if (null == databaseConnection) {
            databaseConnection = new DatabaseConnection();
        }

        return databaseConnection;
    }

    public Connection getConnection() throws Exception {

        return DriverManager.getConnection(connectionURL, username, password);

    }

    public void close(final Connection connection) {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("SQL Exception thrown while closing Connection: ",
                        e);
            }
        }
    }

    public void close(final PreparedStatement preparedStatement) {
        if (null != preparedStatement) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(
                        "SQL Exception thrown while closing Prepared statement: ",
                        e);
            }
        }
    }

    public void close(final ResultSet resultSet) {
        if (null != resultSet) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error("SQL Exception thrown while closing Resultset: ",
                        e);
            }
        }
    }

}
