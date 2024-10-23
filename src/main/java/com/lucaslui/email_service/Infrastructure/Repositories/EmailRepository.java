package com.lucaslui.email_service.Infrastructure.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucaslui.email_service.Domain.Models.EmailModel;

public interface EmailRepository extends MongoRepository<EmailModel, String> {

}