/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.dao.factories;

import com.bionic.dao.mysql.MySQLAccountDAO;
import com.bionic.dao.mysql.MySQLTransactionHistory;
import com.bionic.dao.mysql.MySQLUserInformationDAO;
import com.bionic.dao.mysql.MySQLWalletDAO;
import com.bionic.dao.mysql.MySQLAccountType;
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
 * @author oper4
 */
public class MySQLDAOFactory extends DAOFactory {

    String connectionUrl = "jdbc:mysql://localhost:3306/bionic_university";
    String dbUser = "animator404";
    String dbPwd = "4186790";
    Connection connection = null;
    private static MySQLDAOFactory connectionFactory = null;

    @Override
    public Connection getConnection() throws SQLException {
        connection = null;
        connection = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return connection;
    }

    public static MySQLDAOFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new MySQLDAOFactory();
        }
        return connectionFactory;
    }

    @Override
    public IAccount getAccountDAO() {
        return new MySQLAccountDAO();
    }

    @Override
    public IUserInformation getUserInformationDAO() {
        return new MySQLUserInformationDAO();
    }

    @Override
    public ITransactionHistory getTransactionHistoryDAO() {
        return new MySQLTransactionHistory();
    }

    @Override
    public ITransactionType getTransactionTypeDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IWallet getWalletDAO() {
        return new MySQLWalletDAO();
    }

    @Override
    public IAccountType getAccountTypeDAO() {
        return new MySQLAccountType();
    }
}
