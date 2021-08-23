package com.payment.model;

import java.util.List;



public class EmailDetail {
    private String message;
    private List<MessageDetail> reciepient;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MessageDetail> getReciepient() {
        return reciepient;
    }

    public void setReciepient(List<MessageDetail> reciepient) {
        this.reciepient = reciepient;
    }

    @Override
    public String toString() {
        return "EmailDetail{" +
                "message='" + message + '\'' +
                ", reciepient=" + reciepient +
                '}';
    }
}
