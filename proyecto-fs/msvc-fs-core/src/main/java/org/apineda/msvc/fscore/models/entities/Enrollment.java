package org.apineda.msvc.fscore.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    private Student student;

    @Column(name = "academic_year")
    private String academicYear;

    @ManyToOne
    @JoinColumn(name = "responsible_teacher_id", referencedColumnName = "teacher_id", insertable = false, updatable = false)
    private Teacher responsibleTeacher;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "update_date")
    private Date updateDate;


}
