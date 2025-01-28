package com.school.model.teacher;

import com.school.model.schoolClass.Class;
import com.school.model.subject.Subject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name = "class_id")
    private Class schoolClass;
    @ManyToMany(mappedBy = "teachers")
    private Set<Subject> subject = new HashSet<>();
}
