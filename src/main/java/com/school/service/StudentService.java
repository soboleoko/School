package com.school.service;

import com.school.exception.*;
import com.school.model.exam.Exam;
import com.school.model.grade.ExamScore;
import com.school.model.grade.ExamScoreKey;
import com.school.model.student.Student;
import com.school.model.subject.Subject;
import com.school.repository.ExamRepository;
import com.school.repository.ExamScoreRepository;
import com.school.repository.StudentRepository;
import com.school.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ExamRepository examRepository;
    private final ExamScoreRepository scoreRepository;
    private final SubjectRepository subjectRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Student geStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentDoesNotExistException("Student does not exist", HttpStatus.NOT_FOUND));
    }

    @Transactional
    public List<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Student updateStudent(Long id, Student newStudentData) {
        Student foundStudent = studentRepository.findById(id).orElseThrow(() -> new StudentDoesNotExistException("Student does not exist", HttpStatus.NOT_FOUND));
        foundStudent.setFirstName(newStudentData.getFirstName());
        foundStudent.setLastName(newStudentData.getLastName());
        return foundStudent;
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student foundStudent = studentRepository.findById(id).orElseThrow(() -> new StudentDoesNotExistException("Student does not exist", HttpStatus.NOT_FOUND));
        studentRepository.delete(foundStudent);
    }

    @Transactional
    public void assignExamAndScoreToStudent(Long studentId, Long examId, Integer score) {
        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentDoesNotExistException("Student does not exist", HttpStatus.NOT_FOUND));
        Exam foundExam = examRepository.findById(examId)
                .orElseThrow(() -> new TeacherDoesNotExistException("Exam does not exist", HttpStatus.NOT_FOUND));

        ExamScoreKey scoreKey = new ExamScoreKey(studentId, examId);

        ExamScore foundScore = scoreRepository.findById(scoreKey)
                .orElseThrow(() -> new ExamScoreDoesNotExistException("Score does not exist", HttpStatus.NOT_FOUND));

        foundScore.setStudent(foundStudent);
        foundScore.setExam(foundExam);
        foundScore.setScore(score);
    }

    @Transactional
    public void assignSubjectToStudent(Long studentId, Long subjectId) {
        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentDoesNotExistException("Student does not exist", HttpStatus.NOT_FOUND));
        Subject foundSubject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new SubjectDoesNotExistException("Subject does not exist", HttpStatus.NOT_FOUND));
        Set<Subject> subjectSet = Set.of(foundSubject);

        foundStudent.setSubjects(subjectSet);
    }

    @Transactional
    public Set<Subject> getAllSubjectsForStudent(Long studentId) {
        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentDoesNotExistException("Student does not exist", HttpStatus.NOT_FOUND));

        return foundStudent.getSubjects();
    }

    @Transactional
    public Set<ExamScore> getAllScoresForStudent(Long studentId) {
        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentDoesNotExistException("Student does not exist", HttpStatus.NOT_FOUND));

        return foundStudent.getScores();
    }
}