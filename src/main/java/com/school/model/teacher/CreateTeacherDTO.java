package com.school.model.teacher;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateTeacherDTO {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
