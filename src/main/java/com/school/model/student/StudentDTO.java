package com.school.model.student;

import com.school.model.schoolClass.SchoolClassDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private SchoolClassDTO schoolClass;
}
