package com.school.controller;

import com.school.mapper.ExamScoreMapper;
import com.school.mapper.StudentMapper;
import com.school.mapper.SubjectMapper;
import com.school.model.grade.ScoreDTO;
import com.school.model.student.CreateStudentDTO;
import com.school.model.student.StudentDTO;
import com.school.model.subject.SubjectDTO;
import com.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/students")
@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final SubjectMapper subjectMapper;
    private final ExamScoreMapper scoreMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public StudentDTO addStudent(@RequestBody CreateStudentDTO createSchoolClassDTO) {
        return studentMapper.mapToStudentDTO(studentService.addStudent(studentMapper.mapToStudent(createSchoolClassDTO)));
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentMapper.mapToStudentDTO(studentService.geStudentById(id));
    }

    @GetMapping
    public List<StudentDTO> getAllStudents(Pageable pageable) {
        return studentMapper.mapToStudentDTOList(studentService.getAllStudents(pageable));
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@RequestBody CreateStudentDTO newStudentData, @PathVariable Long id) {
        return studentMapper.mapToStudentDTO(studentService.updateStudent(id, studentMapper.mapToStudent(newStudentData)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{studentId}/exam/1/assign")
    public void assignExamAndScoreToStudent(@PathVariable Long studentId, @PathVariable Long examId, @RequestParam Integer score) {
        studentService.assignExamAndScoreToStudent(studentId, examId, score);
    }

    @GetMapping("/{studentId}/subjects")
    public Set<SubjectDTO> getAllSubjectsForStudent(@PathVariable Long studentId) {
        return subjectMapper.mapToSubjectDTOSet(studentService.getAllSubjectsForStudent(studentId));
    }

    @GetMapping("/{studentId}/scores")
    public Set<ScoreDTO> getAllScoresForStudent(@PathVariable Long studentId) {
        return scoreMapper.mapToScoreDTOSet(studentService.getAllScoresForStudent(studentId));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("{studentId}/subject/{subjectId}/assign")
    public void assignSubjectToStudent(@PathVariable Long studentId, @PathVariable Long subjectId) {
        studentService.assignSubjectToStudent(studentId, subjectId);
    }
}
