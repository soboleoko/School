package com.school.model.student;

import com.school.model.exam.Exam;
import com.school.model.schoolClass.Class;
import com.school.model.subject.Subject;
import com.school.model.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Teacher> teachers;
    private Set<Subject> subjects;
    private Set<Exam> exams;
    private Class schoolClass;
}
