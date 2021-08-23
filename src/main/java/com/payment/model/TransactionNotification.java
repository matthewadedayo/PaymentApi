package com.payment.model;


public class TransactionNotification  {

  private  String message;
  private String status;
    private  String amount;
    private String trandate;
    private  String narration;
    private String sourceAccno;
    private  String destinationName;
    private String getDestinationAcc;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTrandate() {
        return trandate;
    }

    public void setTrandate(String trandate) {
        this.trandate = trandate;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getSourceAccno() {
        return sourceAccno;
    }

    public void setSourceAccno(String sourceAccno) {
        this.sourceAccno = sourceAccno;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getGetDestinationAcc() {
        return getDestinationAcc;
    }

    public void setGetDestinationAcc(String getDestinationAcc) {
        this.getDestinationAcc = getDestinationAcc;
    }
}
