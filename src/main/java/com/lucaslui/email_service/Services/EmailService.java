package com.lucaslui.email_service.Services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaslui.email_service.Domain.Enums.EmailStatus;
import com.lucaslui.email_service.Domain.Models.EmailModel;
import com.lucaslui.email_service.Infrastructure.Repositories.EmailRepository;
import com.lucaslui.email_service.Services.Interfaces.EmailProvider;

@Service
public class EmailService {

    @Autowired
    private EmailProvider emailProvider;

    @Autowired
    private EmailRepository emailRepository;

    public EmailModel sendEmail(EmailModel email) {

        email.setStatus(EmailStatus.PENDING);
        try {
            emailProvider.sendEmail(email);
            email.setStatus(EmailStatus.SENT);
        } catch (Exception e) {
            email.setStatus(EmailStatus.ERROR);
        } finally {
            email.setCreatedAt(new Date());
            email.setUpdatedAt(new Date());
            emailRepository.save(email);
        }

        return email;
    }
}
