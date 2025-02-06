package com.school.controller;

import com.school.mapper.ExamMapper;
import com.school.model.exam.CreateExamDTO;
import com.school.model.exam.ExamDTO;
import com.school.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/exams")
@RequiredArgsConstructor
@RestController
public class ExamController {
    private final ExamService examService;
    private final ExamMapper examMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ExamDTO addExam(@RequestBody CreateExamDTO createExamDTO) {
        return examMapper.mapToExamDTO(examService.addExam(examMapper.mapToExam(createExamDTO)));
    }

    @GetMapping("/{id}")
    public ExamDTO getExamById(@PathVariable Long id) {
        return examMapper.mapToExamDTO(examService.getExamById(id));
    }

    @GetMapping()
    public List<ExamDTO> getAllExams(Pageable pageable) {
        return examMapper.mapToExamDTOList(examService.getAllExams(pageable));
    }

    @PutMapping("/{id}")
    public ExamDTO updateExam(@RequestBody CreateExamDTO newExamData, @PathVariable Long id) {
        return examMapper.mapToExamDTO(examService.updateExam(id, examMapper.mapToExam(newExamData)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
    }
}
