package com.bionic.dao.factories;

import com.bionic.dao.interfaces.ITransactionHistory;
import com.bionic.dao.interfaces.IUserInformation;
import com.bionic.dao.interfaces.IAccount;
import com.bionic.dao.factories.DB2DAOFactory;
import com.bionic.dao.factories.MySQLDAOFactory;
import com.bionic.dao.factories.OracleDAOFactory;
import com.bionic.dao.interfaces.IAccountType;
import com.bionic.dao.interfaces.ITransactionType;
import com.bionic.dao.interfaces.IWallet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Eugene
 */
public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;

    public abstract Connection getConnection() throws SQLException;

    public abstract IAccount getAccountDAO();

    public abstract IUserInformation getUserInformationDAO();

    public abstract ITransactionHistory getTransactionHistoryDAO();

    public abstract ITransactionType getTransactionTypeDAO();

    public abstract IWallet getWalletDAO();

    public abstract IAccountType getAccountTypeDAO();

    public static DAOFactory getDAOFactory(int whatFactory) {
        switch (whatFactory) {
            case MYSQL:
                return new MySQLDAOFactory();
            case ORACLE:
                return new OracleDAOFactory();
            case DB2:
                return new DB2DAOFactory();
            default:
                return null;
        }
    }
}
