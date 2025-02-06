package com.school.service;

import com.school.exception.SubjectDoesNotExistException;
import com.school.exception.TeacherDoesNotExistException;
import com.school.model.subject.Subject;
import com.school.model.teacher.Teacher;
import com.school.repository.SubjectRepository;
import com.school.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    public Subject addClass(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Transactional
    public Subject getClassById(Long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new SubjectDoesNotExistException("Subject does not exist", HttpStatus.NOT_FOUND));
    }

    @Transactional
    public List<Subject> getAllSchoolClasses(Pageable pageable) {
        return subjectRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Subject updateSchoolClass(Long id, Subject newSubjectData) {
        Subject foundSubject = subjectRepository.findById(id).orElseThrow(() -> new SubjectDoesNotExistException("Subject does not exist", HttpStatus.NOT_FOUND));
        foundSubject.setName(newSubjectData.getName());
        return foundSubject;
    }

    @Transactional
    public void deleteSchoolClass(Long id) {
        Subject foundSubject = subjectRepository.findById(id).orElseThrow(() -> new SubjectDoesNotExistException("Subject does not exist", HttpStatus.NOT_FOUND));
        subjectRepository.delete(foundSubject);
    }

    @Transactional
    public void assignTeacherToSubject(Long teacherId, Long subjectId) {
        Subject foundSubject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new SubjectDoesNotExistException("Subject does not exist", HttpStatus.NOT_FOUND));
        Teacher foundTeacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new TeacherDoesNotExistException("Teacher does not exist", HttpStatus.NOT_FOUND));
        foundTeacher.getSubjects().add(foundSubject);
        foundSubject.getTeachers().add(foundTeacher);
    }
}
