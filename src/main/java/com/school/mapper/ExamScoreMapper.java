package com.school.mapper;

import com.school.model.grade.CreateScoreDTO;
import com.school.model.grade.ExamScore;
import com.school.model.grade.ExamScoreKey;
import com.school.model.grade.ScoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ExamScoreMapper {
    @Mapping(target = "id", source = "id", qualifiedByName = "mapToLong")
    ScoreDTO mapToExamScoreDTO(ExamScore examScore);

    List<ScoreDTO> mapToExamScoreList(List<ExamScore> examScores);

    Set<ScoreDTO> mapToScoreDTOSet(Set<ExamScore> examScores);

    @Named("mapToLong")
    static Long mapToLong(ExamScoreKey examScoreKey) {
        return examScoreKey != null ? examScoreKey.getExamId() : null;
    }
}
