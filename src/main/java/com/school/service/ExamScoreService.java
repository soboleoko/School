package com.school.service;

import com.school.exception.ExamDoesNotExistException;
import com.school.exception.ExamScoreAlreadyExistsException;
import com.school.exception.ExamScoreDoesNotExistException;
import com.school.exception.StudentDoesNotExistException;
import com.school.model.exam.Exam;
import com.school.model.grade.CreateScoreDTO;
import com.school.model.grade.ExamScore;
import com.school.model.grade.ExamScoreKey;
import com.school.model.student.Student;
import com.school.repository.ExamRepository;
import com.school.repository.ExamScoreRepository;
import com.school.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExamScoreService {
    private final ExamScoreRepository scoreRepository;
    private final StudentRepository studentRepository;
    private final ExamRepository examRepository;

    public ExamScore addExamScore(CreateScoreDTO createScoreDTO) {
        ExamScoreKey key = new ExamScoreKey(createScoreDTO.getStudentId(), createScoreDTO.getExamId());
        if (scoreRepository.existsById(key)) {
            throw new ExamScoreAlreadyExistsException("Provided score already exists", HttpStatus.BAD_REQUEST);
        }
        Exam foundExam = examRepository.findById(createScoreDTO.getExamId())
                .orElseThrow(() -> new ExamDoesNotExistException("Exam does not exist", HttpStatus.NOT_FOUND));
        Student foundStudent = studentRepository.findById(createScoreDTO.getStudentId())
                .orElseThrow(() -> new StudentDoesNotExistException("Student does not exist", HttpStatus.NOT_FOUND));
        ExamScore examScore = new ExamScore(key, foundStudent, foundExam, createScoreDTO.getScore());
        return scoreRepository.save(examScore);
    }

    @Transactional
    public ExamScore getExamScoreById(Long studentId, Long examId) {
        return scoreRepository.findByStudentIdAndExamId(studentId, examId).orElseThrow(() -> new ExamScoreDoesNotExistException("Exam score does not exist", HttpStatus.NOT_FOUND));
    }

    @Transactional
    public List<ExamScore> getAllExamScores(Pageable pageable) {
        return scoreRepository.findAll(pageable).getContent();
    }

    @Transactional
    public ExamScore updateExamScore(Long studentId, Long examId, CreateScoreDTO newExamData) {
        ExamScore foundScore = scoreRepository.findByStudentIdAndExamId(studentId, examId).orElseThrow(() -> new ExamScoreDoesNotExistException("Exam score does not exist", HttpStatus.NOT_FOUND));
        foundScore.setScore(newExamData.getScore());
        return foundScore;
    }

    @Transactional
    public void deleteExamScore(Long studentId, Long examId) {
        ExamScore foundExamScore = scoreRepository.findByStudentIdAndExamId(studentId, examId).orElseThrow(() -> new ExamScoreDoesNotExistException("Exam score does not exist", HttpStatus.NOT_FOUND));
        scoreRepository.delete(foundExamScore);
    }
}
