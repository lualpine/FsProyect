package org.apineda.msvc.fscore.models.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HighScoringStudentInfo {
    private String teacherName;
    private String gradeName;
    private BigDecimal averageGrade;
    private String studentName;
    private BigDecimal studentGrade;
}
