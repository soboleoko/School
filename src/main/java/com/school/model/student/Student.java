package com.school.model.student;

import com.school.model.exam.Exam;
import com.school.model.grade.ExamScore;
import com.school.model.schoolClass.Class;
import com.school.model.subject.Subject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "students")
    private Set<Subject> subjects = new HashSet<>();
    @OneToMany(mappedBy = "student")
    private Set<Exam> exams = new HashSet<>();
    @OneToMany(mappedBy = "student")
    private Set<ExamScore> scores = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class schoolClass;
}
