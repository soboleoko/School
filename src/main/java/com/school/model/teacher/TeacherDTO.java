package com.school.model.teacher;

import com.school.model.schoolClass.SchoolClassDTO;
import com.school.model.student.Student;
import com.school.model.subject.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private SubjectDTO subject;
    private SchoolClassDTO schoolClass;
    private Set<Student> students;
}
