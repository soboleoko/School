package com.school.model.schoolClass;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateClassDTO {
    @NotNull
    private String name;
    @NotNull
    private int studentsQuantity;
}
