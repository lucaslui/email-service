package com.lucaslui.email_service.Domain.Models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lucaslui.email_service.Domain.Enums.EmailStatus;

import lombok.Data;

@Data
@Document(collection = "emails")
public class EmailModel {
    @Id
    private String id;
    private String to;
    private String subject;
    private String body;
    private EmailStatus status;
    private Date createdAt;
    private Date updatedAt;
}
