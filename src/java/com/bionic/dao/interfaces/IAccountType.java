/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.dao.interfaces;

import com.bionic.entities.AccountType;

/**
 *
 * @author Eugene
 */
public interface IAccountType {

    public boolean addAccountType(AccountType accountType);

    public String getAccountDescription(String accountTypeId);
}
