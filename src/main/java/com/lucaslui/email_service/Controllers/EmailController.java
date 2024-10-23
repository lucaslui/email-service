package com.lucaslui.email_service.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaslui.email_service.Controllers.models.EmailRequestBody;
import com.lucaslui.email_service.Domain.Models.EmailModel;
import com.lucaslui.email_service.Services.EmailService;

import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public EmailModel postMethodName(@RequestBody @Valid EmailRequestBody body) {
        EmailModel email = new EmailModel();
        BeanUtils.copyProperties(body, email);
        EmailModel emailSaved = this.emailService.sendEmail(email);
        return emailSaved;
    }

}
