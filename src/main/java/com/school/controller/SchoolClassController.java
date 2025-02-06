package com.school.controller;

import com.school.mapper.SchoolClassMapper;
import com.school.model.schoolClass.CreateSchoolClassDTO;
import com.school.model.schoolClass.SchoolClassDTO;
import com.school.service.SchoolClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/classes")
@RequiredArgsConstructor
@RestController
public class SchoolClassController {
    private final SchoolClassService schoolClassService;
    private final SchoolClassMapper schoolClassMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SchoolClassDTO addClass(@RequestBody CreateSchoolClassDTO createSchoolClassDTO) {
        return schoolClassMapper.mapToSchoolClassDTO(schoolClassService.addClass(schoolClassMapper.mapToSchoolClass(createSchoolClassDTO)));
    }

    @GetMapping("/{id}")
    public SchoolClassDTO getClassById(@PathVariable Long id) {
        return schoolClassMapper.mapToSchoolClassDTO(schoolClassService.getClassById(id));
    }

    @GetMapping
    public List<SchoolClassDTO> getAllClasses(Pageable pageable) {
        return schoolClassMapper.mapToSchoolClassDTOList(schoolClassService.getAllSchoolClasses(pageable));
    }

    @PutMapping("/{id}")
    public SchoolClassDTO updateExam(@RequestBody CreateSchoolClassDTO newClassData, @PathVariable Long id) {
        return schoolClassMapper.mapToSchoolClassDTO(schoolClassService.updateSchoolClass(id, schoolClassMapper.mapToSchoolClass(newClassData)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Long id) {
        schoolClassService.deleteSchoolClass(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/{schoolClassId}/assign-student/{studentId}")
    public void assignStudentToSchoolClass(@PathVariable Long schoolClassId, @PathVariable Long studentId) {
        schoolClassService.assignStudentToSchoolClass(studentId, schoolClassId);
    }
}
