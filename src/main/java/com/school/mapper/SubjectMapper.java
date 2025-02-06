package com.school.mapper;

import com.school.model.subject.CreateSubjectDTO;
import com.school.model.subject.Subject;
import com.school.model.subject.SubjectDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    Subject mapToSubject(CreateSubjectDTO createSubjectDTO);

    SubjectDTO mapToSubjectDTO(Subject subject);

    List<SubjectDTO> mapToSubjectDTOList(List<Subject> subjects);

    Set<SubjectDTO> mapToSubjectDTOSet (Set<Subject> subjects);
}
