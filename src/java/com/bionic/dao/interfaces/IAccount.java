/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.dao.interfaces;

import com.bionic.entities.Account;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author oper4
 */
public interface IAccount {

    public void addAccount(Account account) throws SQLException;

    public boolean confirmExistenceByAccountID(Long accountId);

    public boolean confirmExistenceByLogin(String login);

    public boolean confirmExistenceByWalletID(Long walletID);

    public String getAccountTypeId(Long account_id);

    public String getAccountDescription(String account_type_id);

    public boolean changeAccountTypeId(Long account_id, String newAccountType);

    public Long getWalletId(Long account_id);

    public Long getAccountId(String login);

    public boolean changeLogin(Long account_id, String newLogin);

    public boolean confirmPassword(String login, String password);

    public Map getAccountInfo(String login);

    public Long generateWalletID();

    public Long generateAccountID();
}
