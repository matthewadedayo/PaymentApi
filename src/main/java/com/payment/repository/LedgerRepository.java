package com.payment.repository;

import com.payment.model.TransactionLedger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerRepository extends CrudRepository<TransactionLedger, Long> {
    TransactionLedger findByUsername(String username);
    
     TransactionLedger findByAccountNo(String username);

    TransactionLedger findByCrncy(String crncy);

}
