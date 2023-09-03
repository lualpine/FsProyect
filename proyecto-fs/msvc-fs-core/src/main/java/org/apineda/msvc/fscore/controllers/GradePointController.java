package org.apineda.msvc.fscore.controllers;

import lombok.RequiredArgsConstructor;
import org.apineda.msvc.fscore.models.entities.BestSubjectByGrade;
import org.apineda.msvc.fscore.models.entities.HighScoringStudentInfo;
import org.apineda.msvc.fscore.models.entities.Teacher;
import org.apineda.msvc.fscore.usecases.GradePointUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="api")
@RequiredArgsConstructor
public class GradePointController {
    private final GradePointUseCase gradePointUseCase;

    @GetMapping("/getinfostudent-average")
    public ResponseEntity<List<HighScoringStudentInfo>> getInfoStudent(){
        var result = gradePointUseCase.getInfoStudent();
        if(!result.isEmpty()){
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/getinfograde")
    public ResponseEntity<List<BestSubjectByGrade>> getInfoGrade(){
        var result = gradePointUseCase.getInfoGrade();
        if(!result.isEmpty()){
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.notFound().build();
    }
}
