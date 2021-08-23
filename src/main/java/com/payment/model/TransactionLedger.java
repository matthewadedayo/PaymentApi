package com.payment.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Ledger")
public class TransactionLedger {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String username;
    private String email;
    private String phone;

    private Integer userId;
    private BigDecimal availableAmount;
    private BigDecimal allowedAmountperTransaction;
    private BigDecimal maximumAllowedAmount;
    private BigDecimal ledgerAmount;
    private String accountNo;
    private String accountStatus;
    private String lienAmount;
    private String crncy;
    private String balanceDate;
    private String transactionDate;

    public String getAccountNo() {
        return accountNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public BigDecimal getAllowedAmountperTransaction() {
        return allowedAmountperTransaction;
    }

    public void setAllowedAmountperTransaction(BigDecimal allowedAmountperTransaction) {
        this.allowedAmountperTransaction = allowedAmountperTransaction;
    }

    public BigDecimal getMaximumAllowedAmount() {
        return maximumAllowedAmount;
    }

    public void setMaximumAllowedAmount(BigDecimal maximumAllowedAmount) {
        this.maximumAllowedAmount = maximumAllowedAmount;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public BigDecimal getLedgerAmount() {
        return ledgerAmount;
    }

    public void setLedgerAmount(BigDecimal ledgerAmount) {
        this.ledgerAmount = ledgerAmount;
    }


    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getLienAmount() {
        return lienAmount;
    }

    public void setLienAmount(String lienAmount) {
        this.lienAmount = lienAmount;
    }

    public String getCrncy() {
        return crncy;
    }

    public void setCrncy(String crncy) {
        this.crncy = crncy;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }
}
