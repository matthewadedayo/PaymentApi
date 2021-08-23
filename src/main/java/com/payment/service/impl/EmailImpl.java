package com.payment.service.impl;

import com.payment.model.EmailDto;
import com.payment.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;


    @Service
    public class EmailImpl implements EmailService {


       @Autowired
        private JavaMailSender emailSender;

        @Override
        public void sendNotification(EmailDto emailDto) {

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(String.valueOf(emailDto.getData().getReciepient().get(0)));
            simpleMailMessage.setSubject("Transaction Notification");
            simpleMailMessage.setText(emailDto.getData().getMessage());
            emailSender.send(simpleMailMessage);
        }

        @Override
        public void sendSimpleEmail(String toAddress, String subject, String message) {

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(toAddress);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);
            emailSender.send(simpleMailMessage);
        }

        @Override
        public void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException {

            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject(subject);
            messageHelper.setText(message);
            FileSystemResource file= new FileSystemResource(ResourceUtils.getFile(attachment));
            messageHelper.addAttachment("Purchase Order", file);
            emailSender.send(mimeMessage);
        }
    }