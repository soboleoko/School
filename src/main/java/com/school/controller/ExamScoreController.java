package com.school.controller;

import com.school.mapper.ExamScoreMapper;
import com.school.model.grade.CreateScoreDTO;
import com.school.model.grade.ScoreDTO;
import com.school.service.ExamScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/scores")
@RequiredArgsConstructor
@RestController
public class ExamScoreController {
    private final ExamScoreService scoreService;
    private final ExamScoreMapper scoreMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ScoreDTO addExamScore(@RequestBody CreateScoreDTO createScoreDTO) {
        return scoreMapper.mapToExamScoreDTO(scoreService.addExamScore(createScoreDTO));
    }

    @GetMapping("/student/{studentId}/exam/{examId}")
    public ScoreDTO getExamScoreById(@RequestParam Long studentId, @RequestParam Long examId) {
        return scoreMapper.mapToExamScoreDTO(scoreService.getExamScoreById(studentId, examId));
    }

    @GetMapping()
    public List<ScoreDTO> getAllExamScores(Pageable pageable) {
        return scoreMapper.mapToExamScoreList(scoreService.getAllExamScores(pageable));
    }

    @PutMapping("/student/{studentId}/exam/{examId}")
    public ScoreDTO updateExamScore(@RequestBody CreateScoreDTO newScoreData, @PathVariable Long studentId, @PathVariable Long examId) {
        return scoreMapper.mapToExamScoreDTO(scoreService.updateExamScore(studentId, examId, newScoreData));
    }

    @DeleteMapping("/student/{studentId}/exam/{examId}")
    public void deleteExamScore(@PathVariable Long studentId, @PathVariable Long examId) {
        scoreService.deleteExamScore(studentId, examId);
    }
}