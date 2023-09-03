package org.apineda.msvc.fscore.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "grade_point")
public class GradePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_point_id")
    private Long gradePointId;

    @ManyToOne
    @JoinColumn(name = "student_subject_id", referencedColumnName = "student_subject_id", insertable = false, updatable = false)
    private StudentSubject studentSubject;

    @ManyToOne
    @JoinColumn(name = "grading_teacher_id", referencedColumnName = "teacher_id", insertable = false, updatable = false)
    private Teacher gradingTeacher;

    @Column(name = "score")
    private BigDecimal score;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "update_date")
    private Date updateDate;

}
