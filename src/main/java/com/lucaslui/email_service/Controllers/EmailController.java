package com.lucaslui.email_service.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaslui.email_service.Controllers.models.EmailRequestBody;
import com.lucaslui.email_service.Domain.Models.EmailModel;
import com.lucaslui.email_service.Services.EmailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Tag(name = "Email", description = "Group methods to manage emails.")
    @Operation(summary = "Send an email", description = "Send an email to the recipient.")
    @PostMapping
    public EmailModel sendEmail(@RequestBody @Valid @Parameter(description = "HTTP body to send email",required = true) EmailRequestBody body) {
        EmailModel email = new EmailModel();
        BeanUtils.copyProperties(body, email);
        EmailModel emailSaved = this.emailService.sendEmail(email);
        return emailSaved;
    }

    @Tag(name = "Email", description = "Group methods to manage emails.")
    @Operation(summary = "List emails", description = "List all emails sent.")
    @GetMapping
    public List<EmailModel> listEmails() {
        return this.emailService.listEmails();
    }    

}
