package com.school.service;

import com.school.exception.TeacherDoesNotExistException;
import com.school.model.teacher.Teacher;
import com.school.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new TeacherDoesNotExistException("Teacher does not exist", HttpStatus.NOT_FOUND));
    }

    @Transactional
    public List<Teacher> getAllTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Teacher updateTeacher(Long id, Teacher newTeacherData) {
        Teacher foundTeacher = teacherRepository.findById(id).orElseThrow(() -> new TeacherDoesNotExistException("Teacher does not exist", HttpStatus.NOT_FOUND));
        foundTeacher.setFirstName(newTeacherData.getFirstName());
        foundTeacher.setLastName(newTeacherData.getLastName());
        return foundTeacher;
    }

    @Transactional
    public void deleteSchoolClass(Long id) {
        Teacher foundTeacher = teacherRepository.findById(id).orElseThrow(() -> new TeacherDoesNotExistException("Teacher does not exist", HttpStatus.NOT_FOUND));
        teacherRepository.delete(foundTeacher);
    }
}
