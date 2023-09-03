package org.apineda.msvc.fscore.usecases;

import lombok.RequiredArgsConstructor;
import org.apineda.msvc.fscore.models.entities.BestSubjectByGrade;
import org.apineda.msvc.fscore.models.entities.HighScoringStudentInfo;
import org.apineda.msvc.fscore.models.entities.Teacher;
import org.apineda.msvc.fscore.services.GradePointService;

import java.util.List;


@RequiredArgsConstructor
public class GradePointUseCase {
    private final GradePointService gradePointService;

    public List<HighScoringStudentInfo> getInfoStudent(){
        return gradePointService.getInfoStudent();
    }
    public List<BestSubjectByGrade> getInfoGrade(){
        return gradePointService.getInfoGrade();
    }
}
