package org.apineda.msvc.fscore.services;

import org.apineda.msvc.fscore.models.entities.BestSubjectByGrade;
import org.apineda.msvc.fscore.models.entities.HighScoringStudentInfo;
import org.apineda.msvc.fscore.models.entities.Teacher;

import java.util.List;
import java.util.Optional;

public interface GradePointService {


    List<HighScoringStudentInfo> getInfoStudent();

    List<BestSubjectByGrade> getInfoGrade();
}
