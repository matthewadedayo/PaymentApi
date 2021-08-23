package com.payment.service.impl;

import com.payment.repository.LedgerRepository;
import com.payment.model.TransactionLedger;
import com.payment.service.LedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LedgerServiceImpl  implements LedgerService {

    @Autowired
    LedgerRepository ledgerepo;


    @Override
    public List<TransactionLedger> findAll() {
        List<TransactionLedger> list = new ArrayList<>();
        ledgerepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public TransactionLedger findByAccno(String accno) {
        TransactionLedger list = new TransactionLedger();
     //   Optional<T> findById(ID var1);
      //  Optional<BenzDto> fr =  benzImpl.findById(id);
        list =  ledgerepo.findByAccountNo(accno);
        return list;
    }

    @Override
    public TransactionLedger findByUsername(String username) {
        TransactionLedger list = new TransactionLedger();
    list=   ledgerepo.findByUsername(username);
        return list;
    }



    @Override
    public  TransactionLedger withdraw(TransactionLedger transactionLedger){
        TransactionLedger user2 = new TransactionLedger();



        return user2;
    }
    @Override
    public TransactionLedger pay(TransactionLedger transactionLedger) {

        TransactionLedger user2 = new TransactionLedger();
        return user2;
    }


    @Override
    public void delete(long id) {
        ledgerepo.delete(id);
    }

    @Override
    public TransactionLedger save(TransactionLedger transactionLedger) {
        return ledgerepo.save(transactionLedger);
    }

}
