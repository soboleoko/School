package com.school.model.grade;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Embeddable
public class ExamScoreKey implements Serializable {
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "exam_id")
    private Long examId;
}
