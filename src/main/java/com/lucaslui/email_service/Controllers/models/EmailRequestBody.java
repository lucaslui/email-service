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
    @NotEmpty
    private String subject;
    @NotEmpty
    private String body;
}
