package com.bionic.dao.mysql;

import com.bionic.connectionpool.ConnectionPool;
import com.bionic.dao.factories.MySQLDAOFactory;
import com.bionic.dao.interfaces.IUserInformation;
import com.bionic.entities.UserInformation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eugene
 */
public class MySQLUserInformationDAO implements IUserInformation {

    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public MySQLUserInformationDAO() {
        super();
        try {
            connection = ConnectionPool.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() throws SQLException {
        connection = MySQLDAOFactory.getInstance().getConnection();
        return connection;
    }

    @Override
    public void add(UserInformation userInfo) {
        try {
            String SQL = "INSERT INTO `bionic_university`.`user_information` (`account_id`, `first_name`,`last_name`,`email`) VALUES (?, ?, ?, ?)";
            connection = ConnectionPool.getInstance().getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setLong(1, userInfo.getAccountId());
            ptmt.setString(2, userInfo.getFirstName());
            ptmt.setString(3, userInfo.getLastName());
            ptmt.setString(4, userInfo.getEmail());
            ptmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, ptmt);
        }
    }

    @Override
    public String getFirstName(Long accountId) {
        try {
            String sql = "SELECT * FROM bionic_university.user_information WHERE account_id=?";
            connection = ConnectionPool.getInstance().getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setLong(1, accountId);
            resultSet = ptmt.executeQuery();
            String result = resultSet.getString("first_name");
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
    public String getSecondName(Long accountId) {
        try {
            String sql = "SELECT * FROM bionic_university.user_information WHERE account_id=?";
            connection = ConnectionPool.getInstance().getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setLong(1, accountId);
            resultSet = ptmt.executeQuery();
            String result = resultSet.getString("second_name");
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
    public String getLastName(Long accountId) {
        try {
            String sql = "SELECT * FROM bionic_university.user_information WHERE account_id=?";
            connection = ConnectionPool.getInstance().getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setLong(1, accountId);
            resultSet = ptmt.executeQuery();
            String result = resultSet.getString("last_name");
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
    public String getEmail(Long accountId) {
        try {
            String sql = "SELECT * FROM bionic_university.user_information WHERE account_id=?";
            connection = ConnectionPool.getInstance().getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setLong(1, accountId);
            resultSet = ptmt.executeQuery();
            String result = resultSet.getString("email");
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
    public Map getUserInformation(Long accountId) {
        String sql = "SELECT * FROM bionic_university.user_information "
                + "WHERE account_id=?";
        try {
            connection = ConnectionPool.getInstance().getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setLong(1, accountId);
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
}
