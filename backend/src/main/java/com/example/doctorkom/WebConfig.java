package com.example.doctorkom;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // You can customize the following CORS configuration as per your needs
        registry.addMapping("/**") // This will apply CORS to all your endpoints
                .allowedOrigins("*") // This allows all origins. For security, list your frontend's URL here.
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*"); // This allows all headers. You can be more restrictive here if you like.
    }
}
