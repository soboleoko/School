package com.school.model.grade;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateScoreDTO {
    @NotNull
    private Integer score;
    @NotNull
    private Long examId;
    @NotNull
    private Long studentId;

}
