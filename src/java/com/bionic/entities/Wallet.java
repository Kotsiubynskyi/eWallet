package com.bionic.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eugene
 */
@Entity
@Table(name = "wallet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wallet.findAll", query = "SELECT w FROM Wallet w"),
    @NamedQuery(name = "Wallet.findByWalletId", query = "SELECT w FROM Wallet w WHERE w.walletId = :walletId"),
    @NamedQuery(name = "Wallet.findByBalance", query = "SELECT w FROM Wallet w WHERE w.balance = :balance"),
    @NamedQuery(name = "Wallet.findByCurrency", query = "SELECT w FROM Wallet w WHERE w.currency = :currency")})
public class Wallet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "wallet_id")
    private Long walletId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "balance")
    private double balance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "currency")
    private String currency;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "walletId")
    private Account account;

    public Wallet() {
    }

    public Wallet(Long walletId) {
        this.walletId = walletId;
    }

    public Wallet(Long walletId, double balance, String currency) {
        this.walletId = walletId;
        this.balance = balance;
        this.currency = currency;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
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
        hash += (walletId != null ? walletId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wallet)) {
            return false;
        }
        Wallet other = (Wallet) object;
        if ((this.walletId == null && other.walletId != null) || (this.walletId != null && !this.walletId.equals(other.walletId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bionic.entities.Wallet[ walletId=" + walletId + " ]";
    }

}
