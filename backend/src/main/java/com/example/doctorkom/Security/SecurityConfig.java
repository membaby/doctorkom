package com.example.doctorkom.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select Username, Password, 1 as enabled from Account where Username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select Username, Role from Account where Username=?");
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http.httpBasic(Customizer.withDefaults())
                   .csrf(AbstractHttpConfigurer::disable)
                   .authorizeHttpRequests(configurer -> configurer
                        .requestMatchers(HttpMethod.POST, "/registration/patient").hasRole("PATIENT")
                        .requestMatchers(HttpMethod.POST, "/registration/doctor").hasRole("DOCTOR")
                        .requestMatchers(HttpMethod.POST, "/login/patient").hasRole("PATIENT")
                        .requestMatchers(HttpMethod.POST, "/login/doctor").hasRole("DOCTOR")
        ).build();
    }
}