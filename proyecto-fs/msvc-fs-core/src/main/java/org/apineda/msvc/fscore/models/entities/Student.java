package org.apineda.msvc.fscore.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
    @ManyToOne
    @JoinColumn(name = "document_type_id", referencedColumnName = "document_type_id")
    private DocumentType documentTypeId;

    @Column(name = "document_number",unique = true)
    private String documentNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;
    @ManyToOne
    @JoinColumn(name = "enrolled_grade", referencedColumnName = "grade_id")
    private Grade enrolledGrade;

    @Column(name = "residence_city")
    private String residenceCity;

    @Column(name = "address")
    private String address;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "mobile_phone")
    private String mobilePhone;
    @ManyToOne
    @JoinColumn(name = "responsible_teacher_id", referencedColumnName = "teacher_id")
    private Teacher responsibleTeacherId;

    @Column(name = "guardian_name")
    private String guardianName;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "update_date")
    private Date updateDate;
}
