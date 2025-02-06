package com.school.model.exam;

import com.school.model.grade.ExamScore;
import com.school.model.student.Student;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private LocalDate date;
    @OneToMany(mappedBy = "exam")
    private Set<ExamScore> scores = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
