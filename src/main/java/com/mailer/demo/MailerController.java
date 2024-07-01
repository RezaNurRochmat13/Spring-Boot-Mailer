package com.mailer.demo;

import jakarta.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MailerController {
    @Autowired
    private JavaMailSender javaMailSender;


    @PostMapping("/send")
    public ResponseEntity<String> postSendEmail(@RequestParam String email) throws AddressException {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        msg.setFrom("no-reply-reja@gmail.com");
        msg.setTo(email);

        javaMailSender.send(msg);

        return new ResponseEntity<String>("Sended email", HttpStatus.CREATED);

    }
}
