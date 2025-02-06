package com.school.service;

import com.school.exception.SchoolClassDoesNotExistException;
import com.school.exception.StudentDoesNotExistException;
import com.school.model.schoolClass.SchoolClass;
import com.school.model.student.Student;
import com.school.repository.SchoolClassRepository;
import com.school.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolClassService {
    private final SchoolClassRepository schoolClassRepository;
    private final StudentRepository studentRepository;

    public SchoolClass addClass(SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }

    @Transactional
    public SchoolClass getClassById(Long schoolClassId) {
        return schoolClassRepository.findById(schoolClassId).orElseThrow(() -> new SchoolClassDoesNotExistException("School class does not exist", HttpStatus.NOT_FOUND));
    }

    @Transactional
    public List<SchoolClass> getAllSchoolClasses(Pageable pageable) {
        return schoolClassRepository.findAll(pageable).getContent();
    }

    @Transactional
    public SchoolClass updateSchoolClass(Long id, SchoolClass newSchoolClassData) {
        SchoolClass foundClass = schoolClassRepository.findById(id).orElseThrow(() -> new SchoolClassDoesNotExistException("School class does not exist", HttpStatus.NOT_FOUND));
        foundClass.setName(newSchoolClassData.getName());
        foundClass.setStudentsQuantity(newSchoolClassData.getStudentsQuantity());
        return foundClass;
    }

    @Transactional
    public void deleteSchoolClass(Long id) {
        SchoolClass foundClass = schoolClassRepository.findById(id).orElseThrow(() -> new SchoolClassDoesNotExistException("School class does not exist", HttpStatus.NOT_FOUND));
        schoolClassRepository.delete(foundClass);
    }

    @Transactional
    public void assignStudentToSchoolClass(Long studentId, Long schoolClassId) {
        SchoolClass foundSchoolClass = schoolClassRepository.findById(schoolClassId)
                .orElseThrow(() -> new SchoolClassDoesNotExistException("School class does not exist", HttpStatus.NOT_FOUND));
        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentDoesNotExistException("Student does not exist", HttpStatus.NOT_FOUND));
        foundStudent.setSchoolClass(foundSchoolClass);
    }
}