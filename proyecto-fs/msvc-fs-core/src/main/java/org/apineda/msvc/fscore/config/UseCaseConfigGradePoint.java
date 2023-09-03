package org.apineda.msvc.fscore.config;

import org.apineda.msvc.fscore.services.GradePointService;
import org.apineda.msvc.fscore.usecases.GradePointUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfigGradePoint {
    @Bean
    public GradePointUseCase crearGradePointUseCase(
            GradePointService gradePointService
    ) {
        return new GradePointUseCase(
                gradePointService);
    }
}
