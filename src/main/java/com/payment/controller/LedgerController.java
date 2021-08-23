package com.payment.controller;

import com.payment.model.TransactionLedger;
import com.payment.service.LedgerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "Ledger Module", value = "Ledger Management")
@RequestMapping("/ledger")
public class LedgerController {

    @Autowired
    private LedgerService ledgerService;

    @RequestMapping(value="/allacc", method = RequestMethod.GET)
    public List<TransactionLedger> listUser(){
        return ledgerService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public TransactionLedger create(@RequestBody TransactionLedger transactionLedger){
        return ledgerService.save(transactionLedger);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        ledgerService.delete(id);
        return "success";
    }


    @RequestMapping(value = "/user/depositpayment", method = RequestMethod.POST)
    public String deposit(@PathVariable(value = "id") Long id){
        ledgerService.delete(id);
        return "success";
    }

}
