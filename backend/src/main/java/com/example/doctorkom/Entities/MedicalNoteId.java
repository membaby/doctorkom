package com.example.doctorkom.Entities;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class MedicalNoteId implements Serializable {
    private Patient patient;
    private Doctor doctor;
    private Date date;
}
