package com.school.model.exam;

import com.school.model.grade.ExamScore;
import com.school.model.student.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExamDTO {
    private Long id;
    private String name;
    private LocalDate date;
    private StudentDTO student;
    private Set<ExamScore> scores;
}
