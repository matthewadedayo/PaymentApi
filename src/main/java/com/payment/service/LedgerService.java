package com.payment.service;

import com.payment.model.TransactionLedger;

import java.util.List;

public interface LedgerService {

    TransactionLedger save(TransactionLedger transactionLedger);
    List<TransactionLedger> findAll();
    TransactionLedger findByAccno(String accno);
    TransactionLedger findByUsername(String username);
    void delete(long id);
    TransactionLedger pay(TransactionLedger transactionLedger);
    TransactionLedger withdraw(TransactionLedger transactionLedger);
}
