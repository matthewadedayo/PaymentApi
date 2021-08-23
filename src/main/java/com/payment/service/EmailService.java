package com.payment.service;

import com.payment.model.EmailDto;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

    public interface EmailService {

        void sendNotification(EmailDto emailDto);

        void sendSimpleEmail(final String toAddress  , final String subject, final String message);
        void sendEmailWithAttachment(final String toAddress, final String subject, final String message, final String attachment) throws MessagingException, FileNotFoundException;
    }