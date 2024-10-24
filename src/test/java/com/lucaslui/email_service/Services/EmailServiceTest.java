package com.lucaslui.email_service.Services;

import static org.mockito.Mockito.*;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.lucaslui.email_service.Domain.Enums.EmailStatus;
import com.lucaslui.email_service.Domain.Models.EmailModel;
import com.lucaslui.email_service.Infrastructure.Repositories.EmailRepository;
import com.lucaslui.email_service.Services.Interfaces.EmailProvider;

@SpringBootTest
public class EmailServiceTest {

    @InjectMocks
    private EmailService emailService;

    @Mock
    private EmailProvider emailProvider;

    @Mock
    private EmailRepository emailRepository;

    @Nested
    @DisplayName("sendEmail")
    class SendEmailTests {

        @Test
        @DisplayName("should return email with status SENT if email is sent successfully")
        public void shouldReturnEmailWithStatusSentIfEmailIsSentSuccessfully() {
            EmailModel email = new EmailModel();
            email.setStatus(EmailStatus.PENDING);

            doNothing().when(emailProvider).sendEmail(email);

            emailService.sendEmail(email);

            verify(emailProvider, times(1)).sendEmail(email);
            verify(emailRepository, times(1)).save(email);
            assert email.getStatus() == EmailStatus.SENT;
            assert email.getCreatedAt() != null;
            assert email.getUpdatedAt() != null;
        }

        @Test
        @DisplayName("should return email with status ERROR if email is not sent successfully")
        public void shouldReturnEmailWithStatusErrorIfEmailIsNotSentSuccessfully() {
            EmailModel email = new EmailModel();
            email.setStatus(EmailStatus.PENDING);

            doThrow(new RuntimeException()).when(emailProvider).sendEmail(email);

            emailService.sendEmail(email);

            verify(emailProvider, times(1)).sendEmail(email);
            verify(emailRepository, times(1)).save(email);
            assert email.getStatus() == EmailStatus.ERROR;
            assert email.getCreatedAt() != null;
            assert email.getUpdatedAt() != null;
        }
    }

    @Nested
    @DisplayName("listEmails")
    class ListEmailsTests {

        @Test
        @DisplayName("should return a list of emails")
        public void shouldReturnAListOfEmails() {
            emailService.listEmails();
            verify(emailRepository, times(1)).findAll();
        }
    }
}
