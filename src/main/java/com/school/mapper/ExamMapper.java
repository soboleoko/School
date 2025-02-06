package com.school.mapper;

import com.school.model.exam.CreateExamDTO;
import com.school.model.exam.Exam;
import com.school.model.exam.ExamDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamMapper {
    Exam mapToExam(CreateExamDTO createExamDTO);

    ExamDTO mapToExamDTO(Exam exam);

    List<ExamDTO> mapToExamDTOList(List<Exam> exams);
}
