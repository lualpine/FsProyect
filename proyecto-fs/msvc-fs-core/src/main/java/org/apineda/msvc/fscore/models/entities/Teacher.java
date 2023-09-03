package org.apineda.msvc.fscore.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;

    @ManyToOne
    @JoinColumn(name = "document_type_id", referencedColumnName = "document_type_id", insertable = false, updatable = false)
    private DocumentType documentType;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "last_education_level_id", referencedColumnName = "last_education_level_id", insertable = false, updatable = false)
    private LastEducationLevel lastEducationLevel;

    @ManyToOne
    @JoinColumn(name = "responsible_grade", referencedColumnName = "grade_id", insertable = false, updatable = false)
    private Grade responsibleGrade;

    @Column(name = "email")
    private String email;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "update_date")
    private Date updateDate;


}
