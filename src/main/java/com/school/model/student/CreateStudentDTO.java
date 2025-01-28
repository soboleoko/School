package com.school.model.student;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateStudentDTO {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

}
