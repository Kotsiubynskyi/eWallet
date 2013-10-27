package com.bionic.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eugene
 */
@Entity
@Table(name = "exchange_rates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExchangeRates.findAll", query = "SELECT e FROM ExchangeRates e"),
    @NamedQuery(name = "ExchangeRates.findByCurrency", query = "SELECT e FROM ExchangeRates e WHERE e.currency = :currency"),
    @NamedQuery(name = "ExchangeRates.findByAsk", query = "SELECT e FROM ExchangeRates e WHERE e.ask = :ask"),
    @NamedQuery(name = "ExchangeRates.findByBid", query = "SELECT e FROM ExchangeRates e WHERE e.bid = :bid")})
public class ExchangeRates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "currency")
    private String currency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASK")
    private double ask;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BID")
    private double bid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currency")
    private Collection<TransactionHistory> transactionHistoryCollection;

    public ExchangeRates() {
    }

    public ExchangeRates(String currency) {
        this.currency = currency;
    }

    public ExchangeRates(String currency, double ask, double bid) {
        this.currency = currency;
        this.ask = ask;
        this.bid = bid;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    @XmlTransient
    public Collection<TransactionHistory> getTransactionHistoryCollection() {
        return transactionHistoryCollection;
    }

    public void setTransactionHistoryCollection(Collection<TransactionHistory> transactionHistoryCollection) {
        this.transactionHistoryCollection = transactionHistoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currency != null ? currency.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExchangeRates)) {
            return false;
        }
        ExchangeRates other = (ExchangeRates) object;
        if ((this.currency == null && other.currency != null) || (this.currency != null && !this.currency.equals(other.currency))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bionic.entities.ExchangeRates[ currency=" + currency + " ]";
    }

}
