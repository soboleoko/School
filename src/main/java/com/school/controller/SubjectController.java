package com.school.controller;

import com.school.mapper.SubjectMapper;
import com.school.model.subject.CreateSubjectDTO;
import com.school.model.subject.SubjectDTO;
import com.school.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/subjects")
@RequiredArgsConstructor
@RestController
public class SubjectController {
    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SubjectDTO addSubject(@RequestBody CreateSubjectDTO createSubjectDTO) {
        return subjectMapper.mapToSubjectDTO(subjectService.addClass(subjectMapper.mapToSubject(createSubjectDTO)));
    }

    @GetMapping("/{id}")
    public SubjectDTO getSubjectById(@PathVariable Long id) {
        return subjectMapper.mapToSubjectDTO(subjectService.getClassById(id));
    }

    @GetMapping
    public List<SubjectDTO> getAllSubjects(Pageable pageable) {
        return subjectMapper.mapToSubjectDTOList(subjectService.getAllSchoolClasses(pageable));
    }

    @PutMapping("/{id}")
    public SubjectDTO updateSubject(@RequestBody CreateSubjectDTO newSubjectData, @PathVariable Long id) {
        return subjectMapper.mapToSubjectDTO(subjectService.updateSchoolClass(id, subjectMapper.mapToSubject(newSubjectData)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSchoolClass(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/{subjectId}/teacher/{teacherId}/assign")
    public void assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId) {
        subjectService.assignTeacherToSubject(teacherId, subjectId);
    }
}