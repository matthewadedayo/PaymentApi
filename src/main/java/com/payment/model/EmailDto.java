package com.payment.model;

public class EmailDto {

    private EmailDetail data;
    private String eventType;
    private String initiator;

    public EmailDetail getData() {
        return data;
    }

    public void setData(EmailDetail data) {
        this.data = data;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }
}
