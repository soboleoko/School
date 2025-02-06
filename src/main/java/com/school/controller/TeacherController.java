package com.school.controller;

import com.school.mapper.TeacherMapper;
import com.school.model.teacher.CreateTeacherDTO;
import com.school.model.teacher.TeacherDTO;
import com.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/teachers")
@RequiredArgsConstructor
@RestController
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TeacherDTO addTeacher(@RequestBody CreateTeacherDTO createTeacherDTO) {
        return teacherMapper.mapToTeacherDTO(teacherService.addTeacher(teacherMapper.mapToTeacher(createTeacherDTO)));
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable Long id) {
        return teacherMapper.mapToTeacherDTO(teacherService.getTeacherById(id));
    }

    @GetMapping
    public List<TeacherDTO> getAllTeachers(Pageable pageable) {
        return teacherMapper.mapToTeacherDTOList(teacherService.getAllTeachers(pageable));
    }

    @PutMapping("/{id}")
    public TeacherDTO updateTeacher(@RequestBody CreateTeacherDTO newTeacherData, @PathVariable Long id) {
        return teacherMapper.mapToTeacherDTO(teacherService.updateTeacher(id, teacherMapper.mapToTeacher(newTeacherData)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteSchoolClass(id);
    }
}
