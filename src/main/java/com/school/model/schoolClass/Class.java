package com.school.model.schoolClass;

import com.school.model.student.Student;
import com.school.model.teacher.Teacher;
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
public class Class {
    @Id
    private String id;
    private String name;
    private int studentsQuantity;
    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @OneToMany(mappedBy = "schoolClass")
    private Set<Student> students = new HashSet<>();
}
