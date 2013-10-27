/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.dao.interfaces;

import com.bionic.entities.Wallet;

/**
 *
 * @author Eugene
 */
public interface IWallet {

    public void addWallet(Wallet wallet);

    public Double getBalance(Long wallet_id);

    public boolean setBalance(Long walletId, Double update);
}
