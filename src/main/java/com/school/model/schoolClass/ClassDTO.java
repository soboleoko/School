package com.school.model.schoolClass;

import com.school.model.student.Student;
import com.school.model.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassDTO {
    private Long id;
    private String name;
    private int studentsQuantity;
    private Teacher teacher;
    private Set<Student> students;
}
