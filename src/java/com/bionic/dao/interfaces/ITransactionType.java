/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.dao.interfaces;

import com.bionic.entities.TransactionType;

/**
 *
 * @author Eugene
 */
public interface ITransactionType {

    public void setTransactionType(TransactionType transType);

    public String getDescription(Long id);
}
