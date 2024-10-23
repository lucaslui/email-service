package com.lucaslui.email_service.Services.Interfaces;

import com.lucaslui.email_service.Domain.Models.EmailModel;

public interface EmailProvider {
    public void sendEmail(EmailModel email);
}
