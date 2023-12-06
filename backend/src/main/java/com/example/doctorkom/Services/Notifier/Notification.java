package com.example.doctorkom.Services.Notifier;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Notification {
    private String to;
    private String subject;
    private String content;

    public String VerifyEmailContent_PD(String email, String code){
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>⚠️ Email Verification ⚠️</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear user,</p>"
                + "    <p>Thank you for signing up! Please verify your account by visiting localhost:3000/verification.</p>"
                + "    <p>Your verification code is "+code+"</p>"
                + "    <p>the code will expire in 24 hours</p>"
                + "  </div>"
                + "</body>"
                + "</html>";
        return htmlContent;
    }

    public String AccountCreatedContent_Patient(){
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>\uD83C\uDF89 Account Created \uD83C\uDF89</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear user,</p>"
                + "    <p>Congratulations! Your account has been successfully created with our system. Welcome to the community!</p>"
                + "    <p>Feel free to explore our platform and make the most of your experience. If you have any questions or need assistance, don't hesitate to contact us.</p>"
                + "    <p>Best regards,</p>"
                + "    <p>The Doctorkom Team</p>"
                + "  </div>"
                + "</body>"
                + "</html>";
        return htmlContent;
    }

    public String AccountCreatedContent_Doctor(String name){
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>\uD83C\uDF89 Welcome, Dr."+name
                +" \uD83C\uDF89</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear Dr."+name
                + ",</p>"
                + "    <p>We are pleased to inform you that your account has been successfully created in our system. Welcome to our esteemed community of healthcare professionals!</p>"
                + "    <p>As a valued member, you play a crucial role in providing quality healthcare to our community. Your expertise and dedication are highly appreciated.</p>"
                + "    <p>We trust that your contributions will significantly impact the well-being of our patients. If you have any inquiries or require assistance, please do not hesitate to reach out to our support team.</p>"
                + "    <p>Thank you for choosing to be part of our community. We look forward to a collaborative and successful journey together.</p>"
                + "    <p>Best regards,</p>"
                + "    <p>The [Your Healthcare System Name] Administration</p>"
                + "  </div>"
                + "</body>"
                + "</html>";

        return htmlContent;
    }

    public String VerifyEmailContent_ClinicAdmin(String code, String FormLink) {
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>⚠️ Email Verification ⚠️</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear Clinic Admin,</p>"
                + "    <p>Thank you for registering with our platform. To complete the account setup for your clinic, please enter this form.</p>"
                + "    <p><a href='" + FormLink + "'>Clinic Information Form</a></p>"
                + "    <p> then enter the verification code on the website to confirm your email and add clinic information.</p>"
                + "    <p><strong>Verification Code: <u>" + code + "</u></strong></p>"
                + "    <p>the code will expire in 24 hours</p>"
                + "  </div>"
                + "</body>"
                + "</html>";
        return htmlContent;
    }
    public String VerifyEmailContent_SystemAdmin(String code, String FormLink) {
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>⚠️ Email Verification ⚠️</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear System Admin,</p>"
                + "    <p>Thank you for registering with our platform. To complete the account setup for your system, please enter this form.</p>"
                + "    <p><a href='" + FormLink + "'>System Information Form</a></p>"
                + "    <p> then enter the verification code on the website to confirm your email and add system information.</p>"
                + "    <p><strong>Verification Code: <u>" + code + "</u></strong></p>"
                + "    <p>the code will expire in 24 hours</p>"
                + "  </div>"
                + "</body>"
                + "</html>";
        return htmlContent;
    }


    public String AccountCreatedContent_ClinicAdmin(){
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>\uD83C\uDF89 Account Created \uD83C\uDF89</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear Clinic Admin,</p>"
                + "    <p>Congratulations! Your account has been successfully created with our system. Welcome to the community!</p>"
                + "    <p>Feel free to explore our platform and make the most of your experience. If you have any questions or need assistance, don't hesitate to contact us.</p>"
                + "    <p>Best regards,</p>"
                + "    <p>The Doctorkom Team</p>"
                + "  </div>"
                + "</body>"
                + "</html>";
        return htmlContent;
    }

    public String AccountCreatedContent_SystemAdmin() {
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>\uD83C\uDF89 Account Created \uD83C\uDF89</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear System Admin,</p>"
                + "    <p>Congratulations! Your account has been successfully created with our system. Welcome to the community!</p>"
                + "    <p>Feel free to explore our platform and make the most of your experience. If you have any questions or need assistance, don't hesitate to contact us.</p>"
                + "    <p>Best regards,</p>"
                + "    <p>The Doctorkom Team</p>"
                + "  </div>"
                + "</body>"
                + "</html>";
        return htmlContent;
    }
}