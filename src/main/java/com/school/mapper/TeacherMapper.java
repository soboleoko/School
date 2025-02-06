package com.school.mapper;

import com.school.model.teacher.CreateTeacherDTO;
import com.school.model.teacher.Teacher;
import com.school.model.teacher.TeacherDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher mapToTeacher(CreateTeacherDTO createTeacherDTO);

    TeacherDTO mapToTeacherDTO(Teacher teacher);

    List<TeacherDTO> mapToTeacherDTOList(List<Teacher> teachers);
}
