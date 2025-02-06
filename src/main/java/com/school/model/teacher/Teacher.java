package com.school.model.teacher;

import com.school.model.schoolClass.SchoolClass;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @OneToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;
    @ManyToMany(mappedBy = "teachers")
    private Set<Subject> subjects = new HashSet<>();
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
