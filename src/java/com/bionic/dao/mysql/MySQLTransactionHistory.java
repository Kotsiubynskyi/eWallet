package com.bionic.dao.mysql;

import com.bionic.dao.factories.MySQLDAOFactory;
import com.bionic.dao.interfaces.ITransactionHistory;
import com.bionic.entities.TransactionHistory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eugene
 */
public class MySQLTransactionHistory implements ITransactionHistory {

    private PreparedStatement ptmt = null;
    private Connection connection = null;

    public Connection getConnection() throws SQLException {
        connection = MySQLDAOFactory.getInstance().getConnection();
        return connection;
    }

    @Override
    public void add(TransactionHistory transHistory) {
        try {
            connection = getConnection();
            String SQL = "INSERT INTO bionic_university.transaction_history (account_id, "
                    + "trans_date,trans_amount, transaction_type_id, currency)"
                    + "VALUES (?, ?, ?, ?, ?)";
            ptmt = connection.prepareStatement(SQL);
            ptmt.setLong(1, transHistory.getAccountId());
            ptmt.setDate(2, new java.sql.Date(transHistory.getTransDate().getTime()));
            ptmt.setDouble(3, transHistory.getTransAmount());
            ptmt.setString(4, transHistory.getTransactionTypeId().getId());
            ptmt.setString(5, transHistory.getCurrency().getCurrency());
            ptmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Sorry, account already exists!");
        } finally {
            try {
                if (ptmt != null) {
                    ptmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("ERROR");
            }
        }
    }

    @Override
    public long getAccount(Long accountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getTransactionTime(Long accountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getAmount(Long accountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
