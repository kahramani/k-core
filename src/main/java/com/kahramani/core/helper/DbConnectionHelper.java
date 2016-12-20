package com.kahramani.core.helper;

import com.kahramani.core.util.ArgumentUtils;

import java.sql.*;
import java.util.Properties;

/**
 * Created by kahramani on 12/20/2016.
 */
public class DbConnectionHelper {

    private String url;
    private String username;
    private String password;
    private Connection connection;
    private PreparedStatement preparedStatement;

    public DbConnectionHelper(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnection() {
        return connection;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    /**
     * to check whether connected to a database or not
     * @return a boolean which refers that there is a connection or not
     */
    public boolean isConnected() {
        if(ArgumentUtils.isNull(this.connection))
            return false;

        try {
            return !this.connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * to open connection to a database
     * @return a Connection which is a connection to the db
     * @throws SQLException if connection could not be established
     */
    public Connection open() throws SQLException {
        ArgumentUtils.hasText(this.url, "Url cannot be null or empty");
        ArgumentUtils.hasText(this.username, "Username cannot be null or empty");
        ArgumentUtils.hasText(this.password, "Password cannot be null or empty");
        this.connection = DriverManager.getConnection(this.url, this.username, this.password);

        return this.connection;
    }

    /**
     * to close connection to a database
     * @throws SQLException if connection could not be closed
     */
    public void close() throws SQLException {
        if(!this.isConnected())
            return;

        this.connection.close();
        this.connection = null;
    }

    /**
     * to get result set after the given query execution
     * @param sql which is wanted to execute
     * @return a ResultSet which hold the result of execution
     * @throws SQLException if query could not be executed
     */
    public ResultSet getResultSet(String sql) throws SQLException {
        return this.getResultSet(sql, null);
    }

    public ResultSet getResultSet(String sql, Properties props) throws SQLException {
        return this.prepareStatement(sql, props).executeQuery(sql);
    }

    /**
     * to prepare a statement
     * @param sql which is wanted to be use as a template
     * @param props statement properties
     * @return a PreparedStatement
     * @throws SQLException if statement could not be created properly
     */
    public PreparedStatement prepareStatement(String sql, Properties props) throws SQLException {
        ArgumentUtils.hasText(sql, "Sql cannot be null or empty");
        if(!this.isConnected())
            return null;

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        if(ArgumentUtils.isEmptyOrNull(props)) {
            // add others to here
            int fetchSize = (int) props.get("fetchSize");

            if(fetchSize > 0)
                preparedStatement.setFetchSize(fetchSize);
        }
        this.preparedStatement = preparedStatement;

        return preparedStatement;
    }
}
