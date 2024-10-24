package com.lucaslui.email_service.Controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentCaptor.forClass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.lucaslui.email_service.Controllers.models.EmailRequestBody;
import com.lucaslui.email_service.Domain.Models.EmailModel;
import com.lucaslui.email_service.Services.EmailService;

@SpringBootTest
public class EmailControllerTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private EmailController emailController;

    @Nested
    @DisplayName("sendEmail")
    class SendEmailTests {

        @Test
        @DisplayName("should return an EmailModel")
        public void shouldReturnAnEmailModelIfEverythingIsOk() {
            EmailRequestBody body = new EmailRequestBody();

            body.setTo("any_email@mail.com");
            body.setSubject("any subject");
            body.setBody("any body");

            EmailModel emailMock = mock(EmailModel.class);

            when(emailService.sendEmail(any(EmailModel.class))).thenReturn(emailMock);

            EmailModel emailSaved = emailController.sendEmail(body);

            assert (emailSaved != null);
        }

        @Test
        @DisplayName("should create Email model with the same values as the EmailRequestBody")
        public void shouldCreateEmailModelWithTheSameValuesAsTheEmailRequestBody() {    
            EmailRequestBody body = new EmailRequestBody();

            body.setTo("any_email@mail.com");
            body.setSubject("any subject");
            body.setBody("any body");

            emailController.sendEmail(body);

            ArgumentCaptor<EmailModel> emailCaptor = forClass(EmailModel.class);
            verify(emailService).sendEmail(emailCaptor.capture());

            EmailModel capturedEmailModel = emailCaptor.getValue();

            assertEquals(body.getTo(), capturedEmailModel.getTo());
            assertEquals(body.getSubject(), capturedEmailModel.getSubject());
            assertEquals(body.getBody(), capturedEmailModel.getBody());
        }
    }

    @Nested
    @DisplayName("listEmails")
    class ListEmailsTests {

        @Test
        @DisplayName("should return a list of EmailModel")
        public void shouldReturnAListOfEmailModel() {
            emailController.listEmails();
            verify(emailService).listEmails();
        }
    }
}
