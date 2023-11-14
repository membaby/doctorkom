package com.example.doctorkom.Services.Notifier;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {
    @Autowired
    private final JavaMailSender mailSender;

    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void SendPatientCreatedEmail(String email) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject("Patient Created");
        notification.setContent("Your account has been created");
        Send(notification);
    }
    public void Send_VerificationEmail(String email) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject("Verification Email");
        //content will be edited later to send a link to verify the account
        notification.setContent("Please verify your email address");
        Send(notification);
    }

    private void Send(Notification notification) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(notification.getTo());
        helper.setSubject(notification.getSubject());
        helper.setText(notification.getContent());
        helper.setFrom("doctorkomegy@outlook.com");

        // Add attachments if needed
        // FileSystemResource file = new FileSystemResource(new File("path/to/attachment.txt"));
        // helper.addAttachment("Attachment.txt", file);

        mailSender.send(mimeMessage);
    }

}
