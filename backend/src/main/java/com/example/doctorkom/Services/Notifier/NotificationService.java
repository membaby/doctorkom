package com.example.doctorkom.Services.Notifier;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    public void SendPatientCreatedEmail(String email) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject("Account  Created");
        notification.setContent(notification.AccountCreatedContent_Patient());
        Send(notification);
    }
    public void SendDoctorCreatedEmail(String email,String name) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject("Account Created");
        notification.setContent(notification.AccountCreatedContent_Doctor(name));
        Send(notification);
    }
    public void SendClinicAdminCreatedEmail(String email) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject("Account Created");
        notification.setContent(notification.AccountCreatedContent_ClinicAdmin());
        Send(notification);
    }
    public void SendSystemAdminCreatedEmail(String email) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject("Account Created");
        notification.setContent(notification.AccountCreatedContent_SystemAdmin());
        Send(notification);
    }
    public void VerificationEmail_PD(String email,String code) throws MessagingException {
        code = code.replaceAll("(.{3})", "$1 ").trim();
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject("Verification Email");
        notification.setContent(notification.VerifyEmailContent_PD(email, code));
        Send(notification);
    }
    public void VerificationEmail_ClinicAdmin(String email,String code,String formlink) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject("Verification Email");
        notification.setContent(notification.VerifyEmailContent_ClinicAdmin(code,formlink));
        Send(notification);
    }
    public void VerificationEmail_SystemAdmin(String email,String code,String formlink) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject("Verification Email");
        notification.setContent(notification.VerifyEmailContent_SystemAdmin(code,formlink));
        Send(notification);
    }
    public void CustomEmail(String email, String subject, String content) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject(subject);
        notification.setContent(content);
        Send(notification);
    }

    private void Send(Notification notification) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(notification.getTo());
        helper.setSubject(notification.getSubject());
        helper.setText(notification.getContent(), true);
        helper.setFrom("doctorkomegy@outlook.com");

        mailSender.send(mimeMessage);
    }


}
