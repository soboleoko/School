package com.school.model.grade;

import com.school.model.exam.ExamDTO;
import com.school.model.student.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScoreDTO {
    private Long id;
    private int score;
    private ExamDTO exam;
    private StudentDTO student;

}
