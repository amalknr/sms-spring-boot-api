package com.apr.students.api;


import com.apr.students.model.Exam;
import com.apr.students.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamResource {

    @Autowired
    private ExamService examService;

    @PostMapping
    public Exam addExam(@RequestBody Exam exam){
        return examService.addExams(exam);
    }

    @GetMapping
    public List<Exam> getExams(){
        return examService.getExams();
    }

    @GetMapping(value = "/{id}")
    public Exam getExam(@PathVariable int id){
        return examService.getExam(id);
    }

    @PutMapping(value = "/{id}")
    public Exam updateExam(@PathVariable int id,@RequestBody Exam exam){
        return examService.updateExam(id,exam);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteExam(@PathVariable int id){
        examService.deleteExam(id);
    }
}
