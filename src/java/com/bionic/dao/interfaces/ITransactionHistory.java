/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.dao.interfaces;

import com.bionic.entities.TransactionHistory;
import java.sql.Date;

/**
 *
 * @author Eugene
 */
public interface ITransactionHistory {

    public void add(TransactionHistory transOut);

    public Double getAmount(Long accountId);

    public long getAccount(Long accountId);

    public Date getTransactionTime(Long accountId);
}
