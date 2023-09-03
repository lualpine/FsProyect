package org.apineda.msvc.fscore.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "subject_name")
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "assigned_teacher_id", referencedColumnName = "teacher_id")
    private Teacher assignedTeacher;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "update_date")
    private Date updateDate;

}
