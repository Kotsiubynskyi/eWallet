/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.dao.interfaces;

import com.bionic.entities.TransactionHistory;
import com.bionic.entities.Wallet;

/**
 *
 * @author Eugene
 */
public interface IExchangeRates {
    public void getExchangeAmmount(Wallet wallet, TransactionHistory transHistory);
}
