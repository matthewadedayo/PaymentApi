package com.payment.service.impl;

import com.payment.repository.LedgerRepository;
import com.payment.repository.TransactionRepository;
import com.payment.model.EmailDto;
import com.payment.model.TransactionException;
import com.payment.model.TransactionLedger;
import com.payment.model.Transactionpay;
import com.payment.service.EmailService;
import com.payment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    EmailService emailService;

    @Autowired
    TransactionRepository transactionRepo;

    @Autowired
    LedgerServiceImpl ledgerServiceImpl;

    @Autowired
    LedgerRepository LedgerRepo;

    @Override
    public Transactionpay save(Transactionpay transactionpay) throws TransactionException {
        return transactionRepo.save(transactionpay);
    }

    @Override
    public List<Transactionpay> findAll() throws TransactionException{
        List<Transactionpay> list = new ArrayList<>();
        transactionRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) throws TransactionException{
        transactionRepo.delete(id);
    }


    @Override
    public Transactionpay pay(Transactionpay transactionpay) throws TransactionException{
        final  String  commissionAccno = "1028856CC";
        String currency = "NGN";
        final String bankcode = "056";
        //CURRENCY CAN BE CHANGE OR KEPT IN YML ON PRODUCTION

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssS");
        String paymentReference = String.format("%s%d", simpleDateFormat.format(new Date()), transactionpay.getUserId());
       transactionpay.setPaymentReference(paymentReference);
        transactionpay.setTranCrncy(currency) ;
        EmailDto emailDto = new EmailDto();
        Transactionpay user2 = new Transactionpay();
        transactionpay.setFee(new BigDecimal("50"));
        TransactionLedger transactionLedger = new TransactionLedger();
        TransactionLedger benDetails = new TransactionLedger();
        TransactionLedger commission = new TransactionLedger();
        transactionLedger = ledgerServiceImpl.findByAccno(transactionpay.getDebitAccountNo().trim());

        benDetails = ledgerServiceImpl.findByAccno(transactionpay.getBenefAccountNo());
        commission = ledgerServiceImpl.findByAccno(commissionAccno);

        if(transactionLedger.getAvailableAmount().doubleValue() < (transactionpay.getAmount().doubleValue()-transactionpay.getFee().doubleValue())){

            throw new TransactionException("Dear Customer,Insufficient funds");

        }

        if(transactionpay.getAmount().doubleValue() > (benDetails.getAllowedAmountperTransaction().doubleValue())){

            throw new TransactionException("Dear Customer,This account is not allowed to receive this huge payment");

        }

        if(transactionpay.getAmount().doubleValue() > (transactionLedger.getAllowedAmountperTransaction().doubleValue())){

            throw new TransactionException("Dear Customer,This account type is not allowed to send  this amount,pls visit the branch");

        }

        if(transactionLedger.getAccountStatus().equalsIgnoreCase("FREEZE")){

            throw new TransactionException("Dear Customer,This account is on freeze,kindly visit the nearest branch for an advice");

        }

        if(benDetails.getAccountStatus().equalsIgnoreCase("CLOSED")){

            throw new TransactionException("Dear Customer,This account is on freeze,kindly visit the nearest branch for an advice");

        }

        if(transactionLedger.getAccountStatus().equalsIgnoreCase("CLOSED")){

            throw new TransactionException("Dear Customer,This account is on freeze,kindly visit the nearest branch for an advice");

        }

        if(transactionpay.getBankcode().equals(bankcode)){
       transactionpay.setTranType("INTRABANK");
        }
        else{
            transactionpay.setTranType("INTERBANK");
        }

     //DEBIT
      double sourceledgeBal =  transactionLedger.getAvailableAmount().doubleValue()-transactionpay.getAmount().doubleValue() -transactionpay.getFee().doubleValue();

        //CREDIT

      double benebal =   transactionLedger.getAvailableAmount().doubleValue() + transactionpay.getAmount().doubleValue();

          transactionLedger.setAvailableAmount(BigDecimal.valueOf(sourceledgeBal));

          // CREDIT COMMISSION ACCOUNT

        double commissionbal =   commission.getAvailableAmount().doubleValue() + transactionpay.getFee().doubleValue();

       commission.setAvailableAmount(BigDecimal.valueOf(commissionbal));
        benDetails.setAvailableAmount(BigDecimal.valueOf(benebal));
        transactionLedger.setTransactionDate(new Date().toString());
        benDetails.setTransactionDate(new Date().toString());
        transactionpay.getTranDate(new Date().toString());
       save(transactionpay);
        ledgerServiceImpl.save(transactionLedger);
        // FOR INTRA BANK TRANSFER
        ledgerServiceImpl.save(benDetails);
//  SAVE COMMISSION BALANCE
        ledgerServiceImpl.save(commission);

        //FOR INTERBANK TRANSFER,AN INTERBANK  API  IS CALLED USING REST TEMPLATE AND LINE 94 IS BEING UPDATED BY THE RECEIVING BANK OR API

        //SEND SMS
        user2.setTranStatus("successful");

        try {
            
            String email = transactionLedger.getEmail();

            emailService.sendSimpleEmail(email, "Transaction Notification", ("TRANSACTION OF "+transactionpay.getAmount()+  "SUCCESSFUL"));
           } catch (MailException mailException) {
       mailException.printStackTrace();
            // return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return user2;
    }


    @Override
    public Transactionpay withdraw(Transactionpay transactionpay){
        Transactionpay user2 = new Transactionpay();



        return user2;
    }
}
