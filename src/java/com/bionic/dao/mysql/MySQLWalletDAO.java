/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.dao.mysql;

/**
 *
 * @author oper4
 */
import com.bionic.connectionpool.ConnectionPool;
import com.bionic.dao.interfaces.IWallet;
import com.bionic.entities.Wallet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLWalletDAO implements IWallet {

    private Connection connection = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultSet = null;
    private Double currentBalance = null;
    private Statement statement = null;

    public MySQLWalletDAO() {
        super();
        try {
            connection = ConnectionPool.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addWallet(Wallet wallet) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String SQL = "INSERT INTO bionic_university.wallet (wallet_id, "
                    + "balance, currency)"
                    + "VALUES (?, ?, ?)";
            ptmt = connection.prepareStatement(SQL);
            ptmt.setLong(1, wallet.getWalletId());
            ptmt.setDouble(2, wallet.getBalance());
            ptmt.setString(3, wallet.getCurrency());
            ptmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
    }

    @Override
    public Double getBalance(Long id) {
        try {
            String sql = "SELECT * FROM bionic_university.wallet WHERE wallet_id=?";
            connection = ConnectionPool.getInstance().getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setLong(1, id);
            resultSet = ptmt.executeQuery();
            Double result = resultSet.getDouble("balance");
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
        return null;
    }

    @Override
    public boolean setBalance(Long walletId, Double update) {
        try {
            String currentBalanceSQL = "SELECT * FROM `bionic_university`.`wallet` WHERE wallet_id=?";
            String updateBalanceSQL = "UPDATE `bionic_university`.`wallet` SET `balance`=? WHERE `wallet_id`=?";
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(currentBalanceSQL);
            currentBalance = resultSet.getDouble("balance");
            ptmt = connection.prepareStatement(updateBalanceSQL);
            ptmt.setDouble(1, currentBalance + update);
            ptmt.setLong(2, walletId);
            ptmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
        return false;
    }
}
