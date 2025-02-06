package com.school.repository;

import com.school.model.grade.ExamScore;
import com.school.model.grade.ExamScoreKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExamScoreRepository extends JpaRepository<ExamScore, ExamScoreKey> {
    Optional<ExamScore> findByStudentIdAndExamId (Long studentId, Long examId);
}
