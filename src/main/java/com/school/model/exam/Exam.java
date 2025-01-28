package com.school.model.exam;

import com.school.model.grade.ExamScore;
import com.school.model.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Exam {
    @Id
    private Long id;
    private String name;
    private LocalDate date;
    @OneToMany(mappedBy = "exam")
    private Set<ExamScore> scores = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
