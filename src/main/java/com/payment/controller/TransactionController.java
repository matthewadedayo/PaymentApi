package com.payment.controller;

import com.payment.model.Transactionpay;
import com.payment.service.TransactionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "Transaction Module", value = "Transaction Management")
@RequestMapping("/transaction")
public class TransactionController {

   @Autowired
    private TransactionService transactionService;

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Transactionpay> listUser(){
        return transactionService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Transactionpay create(@RequestBody Transactionpay user){
        return transactionService.save(user);
    }


    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    ResponseEntity <Transactionpay> pay(@RequestBody Transactionpay transactionpay){

       Transactionpay tr = transactionService.pay(transactionpay);
       if(tr != null) {
           return new ResponseEntity<>(tr, HttpStatus.OK);

       }

       else {
           tr.setTranStatus("unsuccessful");
           return new ResponseEntity<>(tr, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
       }


    }


    @RequestMapping(value = "/depositpayment", method = RequestMethod.POST)
    public ResponseEntity reversal(@PathVariable(value = "id") Long id){
        transactionService.delete(id);
        return ResponseEntity.ok().build();
    }

}
