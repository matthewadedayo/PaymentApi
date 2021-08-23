package com.payment.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Payment")
public class Transactionpay {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String username;
    private String tranType;
    private String bankcode;

    private Integer userId;
    private BigDecimal amount;
    private BigDecimal fee;

    private String benefAccountNo;

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBenefAccountNo() {
        return benefAccountNo;
    }

    public void setBenefAccountNo(String benefAccountNo) {
        this.benefAccountNo = benefAccountNo;
    }

    public String getDebitAccountNo() {
        return debitAccountNo;
    }

    public void setDebitAccountNo(String debitAccountNo) {
        this.debitAccountNo = debitAccountNo;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getTranCrncy() {
        return tranCrncy;
    }

    public void setTranCrncy(String tranCrncy) {
        this.tranCrncy = tranCrncy;
    }

    public String getTranNarration() {
        return tranNarration;
    }

    public void setTranNarration(String tranNarration) {
        this.tranNarration = tranNarration;
    }

    private String debitAccountNo;
    private String paymentReference;
    private String tranCrncy;
    private String tranNarration;
    private String tranDate;
    private String tranStatus;

    public String getTranDate() {
        return tranDate;
    }

    public String getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public String getTranDate(String s) {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
