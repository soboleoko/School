package com.school.model.grade;

import com.school.model.exam.Exam;
import com.school.model.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScoreDTO {
    private Long id;
    private int score;
    private Exam exam;
    private Student student;

}
