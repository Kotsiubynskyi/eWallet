package com.bionic.dao.mysql;

import com.bionic.dao.interfaces.ITransactionType;
import com.bionic.dao.factories.MySQLDAOFactory;
import com.bionic.entities.TransactionType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Eugene
 */
public class MySQLTransactionType implements ITransactionType {

    private PreparedStatement ptmt = null;
    private Connection connection = null;

    public Connection getConnection() throws SQLException {
        connection = MySQLDAOFactory.getInstance().getConnection();
        return connection;
    }

    @Override
    public void setTransactionType(TransactionType transType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescription(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
