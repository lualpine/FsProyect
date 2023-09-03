package org.apineda.msvc.fscore.services;

import org.apineda.msvc.fscore.models.entities.BestSubjectByGrade;
import org.apineda.msvc.fscore.models.entities.HighScoringStudentInfo;
import org.apineda.msvc.fscore.repositories.GradePointDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class GradePointServiceImpl implements GradePointService {
    @Autowired
    private GradePointDataRepository repository;


    @Override
    public List<HighScoringStudentInfo> getInfoStudent() {
        List<HighScoringStudentInfo> HighScoringStudentInfoDTO = new ArrayList<>();

        List<Object[]> results = repository.getInfoStudent();
        for (Object[] row : results) {
            String teacherName = (String) row[0];
            String gradeName = (String) row[1];
            BigDecimal averageGrade = (BigDecimal) row[2];
            String studentName = (String) row[3];
            BigDecimal studentGrade = (BigDecimal) row[4];

            HighScoringStudentInfo dto = new HighScoringStudentInfo();
            dto.setTeacherName(teacherName);
            dto.setGradeName(gradeName);
            dto.setAverageGrade(averageGrade);
            dto.setStudentName(studentName);
            dto.setStudentGrade(studentGrade);

            HighScoringStudentInfoDTO.add(dto);
        }
        return HighScoringStudentInfoDTO;
    }

    @Override
    public List<BestSubjectByGrade> getInfoGrade() {
        List<BestSubjectByGrade> bestSubjectsDTO = new ArrayList<>();

        List<Object[]> results = repository.getInfoGrade();

        for (Object[] row : results) {
            String gradeName = (String) row[0];
            String subject = (String) row[1];
            BigDecimal averageScore = (BigDecimal) row[2];

            BestSubjectByGrade dto = new BestSubjectByGrade();
            dto.setGradeName(gradeName);
            dto.setSubject(subject);
            dto.setAverageScore(averageScore);

            bestSubjectsDTO.add(dto);
        }
        return bestSubjectsDTO;
    }
}
