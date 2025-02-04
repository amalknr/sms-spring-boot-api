package com.apr.students.service;

import com.apr.students.dao.ExamDao;
import com.apr.students.model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExamService {

    @Autowired
    private ExamDao examDao;

   public Exam addExams(Exam exam){
        return examDao.save(exam);
    }

    public List<Exam> getExams(){
       return examDao.findAll();
    }

    public Exam getExam(int id){
       return examDao.findById(id)
               .orElseThrow(()-> new RuntimeException("Exam with ID " + id + " not found"));
    }
    public Exam updateExam(int id,Exam exam){
        if(!examDao.existsById(id)){
            throw new RuntimeException("Exam with ID " + id + " not found");
        }

            exam.setId(id);
            return examDao.save(exam);
    }
    public void deleteExam(int id){
       if (!examDao.existsById(id)){
           throw new RuntimeException(("Exam with ID "+ id + " not found "));
       }
       examDao.deleteById(id);
    }

}
