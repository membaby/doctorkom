package com.example.doctorkom.Services.Notifier;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.doctorkom.Entities.Appointment;


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
    public void VerificationEmail_ClinicAdmin(String email,String code) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject("Verification Email");
        notification.setContent(notification.VerifyEmailContent_ClinicAdmin(email, code));
        Send(notification);
    }
    public void VerificationEmail_SystemAdmin(String email,String code) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject("Verification Email");
        notification.setContent(notification.VerifyEmailContent_SystemAdmin(email, code));
        Send(notification);
    }
    public void AppointmentRescheduledPatient(Appointment oldApp, Appointment newApp) throws MessagingException
    {
        Notification notification = new Notification();
        notification.setTo(oldApp.getPatient().getSystemUser().getAccount().getEmail());
        notification.setSubject("Appointment Rescheduled");
        notification.setContent(notification.AppointmentRescheduledContent_Patient(oldApp,newApp));
        Send(notification);
    }
    public void AppointmentCancelledPatient(Appointment appointment) throws MessagingException
    {
        Notification notification = new Notification();
        notification.setTo(appointment.getPatient().getSystemUser().getAccount().getEmail());
        notification.setSubject("Appointment Rescheduled");
        notification.setContent(notification.AppointmentCancelledContent_Patient(appointment));
        Send(notification);
    }
    public void AppointmentRescheduledDoctor(Appointment oldApp, Appointment newApp) throws MessagingException
    {
        Notification notification = new Notification();
        notification.setTo(oldApp.getTimeSlot().getDoctor().getSystemUser().getAccount().getEmail());
        notification.setSubject("Appointment Rescheduled");
        notification.setContent(notification.AppointmentRescheduledContent_Doctor(oldApp,newApp));
        Send(notification);
    }
    public void AppointmentCancelledDoctor(Appointment appointment) throws MessagingException
    {
        Notification notification = new Notification();
        notification.setTo(appointment.getTimeSlot().getDoctor().getSystemUser().getAccount().getEmail());
        notification.setSubject("Appointment Rescheduled");
        notification.setContent(notification.AppointmentCancelledContent_Doctor(appointment));
        Send(notification);
    }
    public void CustomEmail(String email, String subject, String content) throws MessagingException {
        Notification notification = new Notification();
        notification.setTo(email);
        notification.setSubject(subject);
        notification.setContent(notification.CustomContent(content));
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
