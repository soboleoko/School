package com.school.service;

import com.school.exception.ExamDoesNotExistException;
import com.school.model.exam.Exam;
import com.school.repository.ExamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExamService {
    private final ExamRepository examRepository;

    public Exam addExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Transactional
    public Exam getExamById(Long examId) {
        return examRepository.findById(examId).orElseThrow(() -> new ExamDoesNotExistException("Exam does not exist", HttpStatus.NOT_FOUND));
    }

    @Transactional
    public List<Exam> getAllExams(Pageable pageable) {
        return examRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Exam updateExam(Long id, Exam newExamData) {
        Exam foundExam = examRepository.findById(id).orElseThrow(() -> new ExamDoesNotExistException("Exam does not exist", HttpStatus.NOT_FOUND));
        foundExam.setName(newExamData.getName());
        foundExam.setDate(newExamData.getDate());
        return foundExam;
    }

    @Transactional
    public void deleteExam(Long id) {
        Exam foundExam = examRepository.findById(id).orElseThrow(() -> new ExamDoesNotExistException("Exam does not exist", HttpStatus.NOT_FOUND));
        examRepository.delete(foundExam);
    }
}
