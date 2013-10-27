package com.bionic.dao.mysql;

import com.bionic.connectionpool.ConnectionPool;
import com.bionic.dao.interfaces.IAccount;
import com.bionic.entities.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eugene
 */
public class MySQLAccountDAO implements IAccount {

    private Connection connection = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultSet = null;
    private Random random = new Random(Long.MAX_VALUE);
    private Long id;

    public MySQLAccountDAO() {
        super();
        try {
            connection = ConnectionPool.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addAccount(Account account) throws SQLException {

        connection = ConnectionPool.getInstance().getConnection();
        String SQL = "INSERT INTO bionic_university.account (account_id, "
                + "wallet_id, account_type_id, login, password)"
                + "VALUES (?, ?, ?, ?, ?)";
        ptmt = connection.prepareStatement(SQL);
        ptmt.setLong(1, account.getAccountId());
        ptmt.setLong(2, account.getWalletId().getWalletId());
        ptmt.setString(3, account.getAccountTypeId().getAccountTypeId());
        ptmt.setString(4, account.getLogin());
        ptmt.setString(5, account.getPassword());
        ptmt.executeUpdate();
        ConnectionPool.getInstance().closeConnection(connection, ptmt);
    }

    @Override
    public boolean confirmExistenceByAccountID(Long accountId) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "SELECT * FROM account WHERE account_id=?";
            ptmt = connection.prepareStatement(query);
            ptmt.setLong(1, accountId);
            resultSet = ptmt.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
        return false;
    }

    @Override
    public boolean confirmExistenceByWalletID(Long walletID) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "SELECT * FROM account WHERE wallet_id=?";
            ptmt = connection.prepareStatement(query);
            ptmt.setLong(1, walletID);
            resultSet = ptmt.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
        return false;
    }

    @Override
    public boolean changeAccountTypeId(Long account_id, String newAccountType) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "UPDATE `bionic_university`.`account` SET `account_type_id`=? WHERE `account_id`=?";
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, newAccountType);
            ptmt.setLong(2, account_id);
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
    public boolean changeLogin(Long account_id, String newLogin) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "UPDATE `bionic_university`.`account` SET `login`=? WHERE `account_id`=?";
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, newLogin);
            ptmt.setLong(2, account_id);
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
    public boolean confirmExistenceByLogin(String login) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "SELECT * FROM account WHERE login=?";
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, login);
            resultSet = ptmt.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
        return false;
    }

    @Override
    public String getAccountTypeId(Long account_id) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String sql = "SELECT * FROM bionic_university.account WHERE account_id=?";
            ptmt = connection.prepareStatement(sql);
            ptmt.setLong(1, account_id);
            resultSet = ptmt.executeQuery();
            String result = resultSet.getString("account_type_id");
            if (result != null) {
                return result;
            } else {
                return "Account with such id does not exist";
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Account with such id does not exist";
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }

    }

    @Override
    public String getAccountDescription(String account_type_id) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String sql = "SELECT * FROM bionic_university.account_type WHERE account_type_id=?";
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, account_type_id);
            resultSet = ptmt.executeQuery();
            String result = resultSet.getString("acc_type_desc");
            if (result != null) {
                return result;
            } else {
                return "Such account type does not exist";
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
        return "Such account type does not exist";
    }

    @Override
    public Long getWalletId(Long accountID) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String sql = "SELECT * FROM bionic_university.account WHERE account_id=?";
            ptmt = connection.prepareStatement(sql);
            ptmt.setLong(1, accountID);
            resultSet = ptmt.executeQuery();
            Long result = resultSet.getLong("wallet_id");
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
        return null;
    }

    @Override
    public Long getAccountId(String login) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String sql = "SELECT * FROM bionic_university.account WHERE login=?";
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, login);
            resultSet = ptmt.executeQuery();
            Long result = resultSet.getLong("account_id");
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
        return null;
    }

    @Override
    public boolean confirmPassword(String login, String password) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String sql = "SELECT * FROM bionic_university.account WHERE login=?";
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, login);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("password").equals(password)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("qwe");
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
        return false;
    }

    @Override
    public Map getAccountInfo(String login) {
        String sql = "SELECT * FROM bionic_university.account "
                + "WHERE login=?";
        try {
            connection = ConnectionPool.getInstance().getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, login);
            resultSet = ptmt.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int cols = metaData.getColumnCount();
            HashMap row = null;
            while (resultSet.next()) {
                row = new HashMap(cols, 1);
                for (int i = 1; i <= cols; i++) {
                    row.put(metaData.getColumnName(i),
                            resultSet.getString(i));
                }
            }
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
        return null;
    }

    @Override
    public Long generateWalletID() {
        do {
            id = random.nextLong() >>> 1;
        } while (confirmExistenceByWalletID(id));
        return id;
    }

    @Override
    public Long generateAccountID() {
        do {
            id = random.nextLong() >>> 1;
        } while (confirmExistenceByAccountID(id));
        return id;
    }
}
