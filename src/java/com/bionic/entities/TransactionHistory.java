package com.bionic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eugene
 */
@Entity
@Table(name = "transaction_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionHistory.findAll", query = "SELECT t FROM TransactionHistory t"),
    @NamedQuery(name = "TransactionHistory.findByAccountId", query = "SELECT t FROM TransactionHistory t WHERE t.accountId = :accountId"),
    @NamedQuery(name = "TransactionHistory.findByTransactionId", query = "SELECT t FROM TransactionHistory t WHERE t.transactionId = :transactionId"),
    @NamedQuery(name = "TransactionHistory.findByOherAccountId", query = "SELECT t FROM TransactionHistory t WHERE t.oherAccountId = :oherAccountId"),
    @NamedQuery(name = "TransactionHistory.findByTransAmount", query = "SELECT t FROM TransactionHistory t WHERE t.transAmount = :transAmount"),
    @NamedQuery(name = "TransactionHistory.findByTransDate", query = "SELECT t FROM TransactionHistory t WHERE t.transDate = :transDate")})
public class TransactionHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "account_id")
    private Long accountId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transaction_id")
    private long transactionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oher_account_id")
    private long oherAccountId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trans_amount")
    private double transAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trans_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;
    @JoinColumn(name = "transaction_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransactionType transactionTypeId;
    @JoinColumn(name = "currency", referencedColumnName = "currency")
    @ManyToOne(optional = false)
    private ExchangeRates currency;
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Account account;

    public TransactionHistory() {
    }

    public TransactionHistory(Long accountId) {
        this.accountId = accountId;
    }

    public TransactionHistory(Long accountId, long transactionId, long oherAccountId, double transAmount, Date transDate) {
        this.accountId = accountId;
        this.transactionId = transactionId;
        this.oherAccountId = oherAccountId;
        this.transAmount = transAmount;
        this.transDate = transDate;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getOherAccountId() {
        return oherAccountId;
    }

    public void setOherAccountId(long oherAccountId) {
        this.oherAccountId = oherAccountId;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public TransactionType getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(TransactionType transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public ExchangeRates getCurrency() {
        return currency;
    }

    public void setCurrency(ExchangeRates currency) {
        this.currency = currency;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionHistory)) {
            return false;
        }
        TransactionHistory other = (TransactionHistory) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bionic.entities.TransactionHistory[ accountId=" + accountId + " ]";
    }

}
