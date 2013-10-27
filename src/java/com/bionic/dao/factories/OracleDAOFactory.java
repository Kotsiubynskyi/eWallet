package com.bionic.dao.factories;

import com.bionic.dao.interfaces.IAccount;
import com.bionic.dao.interfaces.IAccountType;
import com.bionic.dao.interfaces.IUserInformation;
import com.bionic.dao.interfaces.ITransactionHistory;
import com.bionic.dao.interfaces.ITransactionType;
import com.bionic.dao.interfaces.IWallet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eugene
 */
public class OracleDAOFactory extends DAOFactory {

    String connectionUrl = "jdbc:oracle://localhost:1251/bionic_unversity";
    String dbUser = "animator404";
    String dbPwd = "4186790";
    private static OracleDAOFactory connectionFactory = null;

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return connection;
    }

    public static OracleDAOFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new OracleDAOFactory();
        }
        return connectionFactory;
    }

    @Override
    public IAccount getAccountDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IUserInformation getUserInformationDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITransactionHistory getTransactionHistoryDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITransactionType getTransactionTypeDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IWallet getWalletDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAccountType getAccountTypeDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
