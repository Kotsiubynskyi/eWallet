/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.dao.mysql;

import com.bionic.entities.Wallet;
import com.bionic.entities.TransactionHistory;
import com.bionic.dao.interfaces.IExchangeRates;
import com.bionic.dao.factories.MySQLDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Eugene
 */
public class MySQLExchangeRate implements IExchangeRates {

    private Connection connection = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultSet = null;

    public MySQLExchangeRate() {
        super();
    }

    public Connection getConnection() throws SQLException {
        connection = MySQLDAOFactory.getInstance().getConnection();
        return connection;
    }

    @Override
    public void getExchangeAmmount(Wallet wallet, TransactionHistory transHistory) {
    }
}
