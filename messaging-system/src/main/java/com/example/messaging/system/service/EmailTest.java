/*
package com.example.messaging.system.service;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.SimpleMailMessage;

import java.util.Properties;

public class EmailTest {
    public static void main(String[] args) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("vamsi.pachiapala@gmail.com");
        mailSender.setPassword("Vamsi@243");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vamsi.pachiapala@gmail.com");
        message.setTo("recipient@example.com");
        message.setSubject("Test Mail");
        message.setText("Hello, this is a test email.");

        mailSender.send(message);

        System.out.println("Email sent successfully!");
    }
}

*/
