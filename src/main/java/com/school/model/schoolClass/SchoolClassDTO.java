package com.school.model.schoolClass;

import com.school.model.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SchoolClassDTO {
    private Long id;
    private String name;
    private int studentsQuantity;
    private Set<Student> students;
}
