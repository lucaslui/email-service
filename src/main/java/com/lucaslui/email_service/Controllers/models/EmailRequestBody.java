package com.lucaslui.email_service.Controllers.models;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.Data;

@Data
public class EmailRequestBody {
    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
    private String to;
    @NotEmpty(message = "The email subject is required.")
    private String subject;
    @NotEmpty(message = "The email body is required.")
    private String body;
}
