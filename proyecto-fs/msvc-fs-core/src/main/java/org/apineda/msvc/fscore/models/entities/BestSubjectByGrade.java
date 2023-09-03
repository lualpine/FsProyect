package org.apineda.msvc.fscore.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@Data
public class BestSubjectByGrade {
    private String gradeName;
    private String subject;
    private BigDecimal averageScore;
}
