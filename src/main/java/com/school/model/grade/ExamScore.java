package com.school.model.grade;

import com.school.model.exam.Exam;
import com.school.model.student.Student;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExamScore {
    @EmbeddedId
    private ExamScoreKey id;
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @MapsId("examId")
    @JoinColumn(name = "exam_id")
    private Exam exam;
    @Column(name = "score")
    private int score;
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
