package org.apineda.msvc.fscore.repositories;

import org.apineda.msvc.fscore.models.entities.BestSubjectByGrade;
import org.apineda.msvc.fscore.models.entities.HighScoringStudentInfo;
import org.apineda.msvc.fscore.models.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GradePointDataRepository extends JpaRepository<Teacher, Long> {
    @Query(value="SELECT\n" +
            "    t.first_name AS teacherName,\n" +
            "    g.name_grade AS gradeName,\n" +
            "    grado_promedio.promedio AS averageGrade,\n" +
            "    st.first_name AS studentName,\n" +
            "    gp.score AS studentGrade\n" +
            "FROM\n" +
            "    teacher t\n" +
            "    JOIN grade g ON t.responsible_grade = g.grade_id\n" +
            "    JOIN subject s ON t.teacher_id  = s.assigned_teacher_id \n" +
            "    JOIN student_subject ss ON s.subject_id = ss.subject_id\n" +
            "    JOIN student st ON ss.student_id = st.student_id\n" +
            "    JOIN grade_point gp ON ss.student_subject_id = gp.student_subject_id\n" +
            "    JOIN (\n" +
            "        SELECT\n" +
            "            g.grade_id,\n" +
            "            AVG(gp.score) AS promedio\n" +
            "        from\n" +
            "       \t\tteacher t\n" +
            "            JOIN grade g ON t.responsible_grade = g.grade_id\n" +
            "    \t\tJOIN subject s ON t.teacher_id  = s.assigned_teacher_id \n" +
            "            JOIN student_subject ss ON s.subject_id = ss.subject_id\n" +
            "            JOIN grade_point gp ON ss.student_subject_id = gp.student_subject_id\n" +
            "        GROUP BY\n" +
            "            g.grade_id\n" +
            "    ) AS grado_promedio ON g.grade_id = grado_promedio.grade_id\n" +
            "WHERE\n" +
            "    gp.score > grado_promedio.promedio\n" +
            "ORDER BY\n" +
            "    gp.score ASC;",nativeQuery = true)
    List<Object[]>getInfoStudent();

    @Query(value="SELECT\n" +
            "    gradeName as gradeName,\n" +
            "    subject as subject,\n" +
            "    averageScore as averageScore\n" +
            "FROM (\n" +
            "    SELECT\n" +
            "        g.name_grade AS gradeName,\n" +
            "        subj.subject_name AS subject,\n" +
            "        AVG(gp.score) AS averageScore,\n" +
            "        RANK() OVER (PARTITION BY g.name_grade ORDER BY AVG(gp.score) DESC) AS Posición\n" +
            "    FROM\n" +
            "        grade g\n" +
            "        JOIN student st ON g.grade_id = st.enrolled_grade\n" +
            "        JOIN student_subject ss ON st.student_id = ss.student_id\n" +
            "        JOIN grade_point gp ON ss.student_subject_id = gp.student_subject_id\n" +
            "        JOIN subject subj ON subj.subject_id = ss.subject_id\n" +
            "    GROUP BY\n" +
            "        g.name_grade, subj.subject_name\n" +
            "        order by averageScore desc\n" +
            ") AS RankedData\n" +
            "WHERE Posición = 1",nativeQuery = true)
    List<Object[]>getInfoGrade();
}
