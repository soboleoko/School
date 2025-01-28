package com.school.model.subject;

import com.school.model.student.Student;
import com.school.model.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDTO {
    private Long id;
    private String name;
    private Student student;
    private Teacher teacher;
}
