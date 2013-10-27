package com.bionic.connectionpool;

import com.bionic.dao.mysql.MySQLAccountDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {

    private static ConnectionPool instance = null;
    private static final String TOMCAT_JNDI_NAME = "java:comp/env";
    private DataSource pool;
    private final String DATASOURCE;

    public ConnectionPool() {
        DATASOURCE = DBConfig.getInstance().getProperty(DBConfig.DATASOURCE);
        initialPool();
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private void initialPool() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup(TOMCAT_JNDI_NAME);
            pool = (DataSource) envContext.lookup(DATASOURCE);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    public void closeConnection(Connection connection, PreparedStatement ptmt) {
        try {
            if (ptmt != null) {
                ptmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
