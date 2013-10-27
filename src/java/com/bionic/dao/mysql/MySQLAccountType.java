/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.dao.mysql;

import com.bionic.connectionpool.ConnectionPool;
import com.bionic.dao.factories.MySQLDAOFactory;
import com.bionic.dao.interfaces.IAccountType;
import com.bionic.entities.AccountType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oper4
 */
public class MySQLAccountType implements IAccountType {

    private Connection connection = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultSet = null;

    public Connection getConnection() throws SQLException {
        connection = MySQLDAOFactory.getInstance().getConnection();
        return connection;
    }

    @Override
    public boolean addAccountType(AccountType acc) {
        try {
            connection = getConnection();
            String SQL = "INSERT INTO bionic_university.account_type (account_type_id, "
                    + "acc_type_desc) VALUES (?, ?)";
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, acc.getAccountTypeId());
            ptmt.setString(2, acc.getAccTypeDesc());
            ptmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
        return false;
    }

    @Override
    public String getAccountDescription(String accountTypeId) {
        try {
            connection = getConnection();
            String SQL = "SELECT * FROM bionic_university.account_type "
                    + "WHERE account_type_id=?";
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, accountTypeId);
            resultSet = ptmt.executeQuery();
            String result = resultSet.getString("acc_type_desc");
            System.out.println(result);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "/pages/loginerror.jsp";
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }

    }
}
