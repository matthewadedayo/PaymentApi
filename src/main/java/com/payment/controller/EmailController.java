package com.payment.controller;


import com.payment.model.EmailDto;
import com.payment.service.EmailService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

    @RestController
    @Api(description = "Email Module", value = "Email Management")
    @RequestMapping("/email")
    public class EmailController {

        private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);

        @Autowired
        EmailService emailService;



        @PostMapping(value = "/transaction")
        public @ResponseBody
        ResponseEntity<?> sendSimpleEmailpost(@RequestBody EmailDto emailDto) {

            try {

                emailService.sendNotification(emailDto);
            } catch (MailException mailException) {
                LOG.error("Error while sending out email..{}", mailException.getStackTrace());
                LOG.error("Error while sending out email..{}", mailException.fillInStackTrace());
                return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
        }

        @GetMapping(value = "/simple-email/{user-email}")
        public @ResponseBody
        ResponseEntity<String> sendSimpleEmail(@PathVariable("user-email") String email) {

            try {

                email = "matthewadedayo@yahoo.com";
                emailService.sendSimpleEmail(email, "Welcome", "This is a welcome email for your!!");
            } catch (MailException mailException) {
                LOG.error("Error while sending out email..{}", mailException.getStackTrace());
                LOG.error("Error while sending out email..{}", mailException.fillInStackTrace());
                return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
        }


        @GetMapping(value = "/simple-order-email/{user-email}")
        public @ResponseBody
        ResponseEntity<String> sendEmailAttachment(@PathVariable("user-email") String email) {

            try {
                emailService.sendEmailWithAttachment(email, "Order Confirmation", "Thanks for your recent order", "classpath:purchase_order.pdf");
            } catch (MessagingException | FileNotFoundException mailException) {
                LOG.error("Error while sending out email..{}", mailException.getStackTrace());
                LOG.error("Error while sending out email..{}", mailException.fillInStackTrace());
                return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>("Please check your inbox for order confirmation", HttpStatus.OK);
        }

    }