package org.apineda.msvc.fscore.models.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "last_education_level")
public class LastEducationLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "last_education_level_id")
    private Long lastEducationLevelId;

    @Column(name = "education_level")
    private String educationLevel;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "update_date")
    private Date updateDate;
}
