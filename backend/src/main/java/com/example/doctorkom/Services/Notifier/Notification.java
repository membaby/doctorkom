package com.example.doctorkom.Services.Notifier;

import lombok.AllArgsConstructor;
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

}