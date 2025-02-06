package com.school.model.student;

import com.school.model.exam.Exam;
import com.school.model.grade.ExamScore;
import com.school.model.schoolClass.SchoolClass;
import com.school.model.subject.Subject;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @ManyToMany(mappedBy = "students")
    private Set<Subject> subjects = new HashSet<>();
    @OneToMany(mappedBy = "student")
    private Set<Exam> exams = new HashSet<>();
    @OneToMany(mappedBy = "student")
    private Set<ExamScore> scores = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
