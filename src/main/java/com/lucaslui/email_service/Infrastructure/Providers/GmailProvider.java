package com.lucaslui.email_service.Infrastructure.Providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.lucaslui.email_service.Domain.Models.EmailModel;
import com.lucaslui.email_service.Services.Interfaces.EmailProvider;

@Component
public class GmailProvider implements EmailProvider {
    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(EmailModel email) {
        System.out.println("Sending email to " + email.getTo());
        System.out.println("Subject: " + email.getSubject());
        System.out.println("Body: " + email.getBody());

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());

        emailSender.send(message);
    }
}
