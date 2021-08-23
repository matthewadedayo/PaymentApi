package com.payment.repository;

import com.payment.model.Transactionpay;
import com.payment.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transactionpay, Long> {
    User findByUsername(String username);
    User findByBenefAccountNo(String accno);
    User findByDebitAccountNo(String accno);

}
