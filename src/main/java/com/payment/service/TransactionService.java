package com.payment.service;

import com.payment.model.TransactionException;
import com.payment.model.Transactionpay;

import java.util.List;

public interface TransactionService {

    Transactionpay save(Transactionpay transactionpay) throws TransactionException;
    List<Transactionpay> findAll() throws TransactionException;
    void delete(long id) throws TransactionException;
    Transactionpay pay(Transactionpay transactionpay) throws TransactionException;
    Transactionpay withdraw(Transactionpay transactionpay)throws TransactionException;
}
