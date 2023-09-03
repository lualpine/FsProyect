package org.apineda.msvc.fscore.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "student_subject")
public class StudentSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_subject_id")
    private Long studentSubjectId;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", insertable = false, updatable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    private Student student;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "update_date")
    private Date updateDate;

}
