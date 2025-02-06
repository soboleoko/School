package com.school.mapper;

import com.school.model.schoolClass.CreateSchoolClassDTO;
import com.school.model.schoolClass.SchoolClass;
import com.school.model.schoolClass.SchoolClassDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolClassMapper {
    SchoolClass mapToSchoolClass(CreateSchoolClassDTO createClassDTO);

    SchoolClassDTO mapToSchoolClassDTO(SchoolClass schoolClass);

    List<SchoolClassDTO> mapToSchoolClassDTOList(List<SchoolClass> schoolClasses);
}
