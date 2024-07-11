package com.example.messaging.system.ordermessage;


import com.example.messaging.system.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.function.Function;

@Configuration
public class MessageFunction {

    private static final Logger log = LoggerFactory.getLogger(MessageFunction.class);
    @Autowired
    private JavaMailSender mailSender;
    @Bean
    public Function<User,String> email() {
        return user -> {
            log.info("message function triggered successfully");
            sendEmail(user);
            return user.email();
        };
    }

    private void sendEmail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.email());
        message.setSubject("selected for Amazon");
        message.setText("Hi "+user.name()+" you got selected for Amazon SDE Role and package will be 30LPA");
        mailSender.send(message);
    }
}
