package com.school.mapper;

import com.school.model.student.CreateStudentDTO;
import com.school.model.student.Student;
import com.school.model.student.StudentDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student mapToStudent(CreateStudentDTO createStudentDTO);

    StudentDTO mapToStudentDTO(Student student);

    List<StudentDTO> mapToStudentDTOList(List<Student> students);
}
