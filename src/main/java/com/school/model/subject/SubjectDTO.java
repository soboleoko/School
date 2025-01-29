package com.school.model.subject;

import com.school.model.student.StudentDTO;
import com.school.model.teacher.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDTO {
    private Long id;
    private String name;
    private StudentDTO student;
    private TeacherDTO teacher;
}
