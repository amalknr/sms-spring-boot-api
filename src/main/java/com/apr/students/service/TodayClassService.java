package com.apr.students.service;

import com.apr.students.dao.SubjectDao;
import com.apr.students.model.TodayClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodayClassService {

    @Autowired
    private final SubjectDao subjectDao;

    public TodayClassService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    // Get all classes
    public List<TodayClass> getAllClasses() {
        return subjectDao.findAll();
    }

    // Get class by ID
    public TodayClass getClassById(Long teacherId) {
        return subjectDao.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Class not found with teacherId: " + teacherId));
    }

    // Create a new class
    public TodayClass createClass(TodayClass todayClass) {
        return subjectDao.save(todayClass);
    }

    // Update an existing class
    public TodayClass updateClass(Long teacherId, TodayClass updatedClass) {
        TodayClass existingClass = getClassById(teacherId);
        existingClass.setTeacherName(updatedClass.getTeacherName());
        existingClass.setTodaySubject(updatedClass.getTodaySubject());
        existingClass.setClassTime(updatedClass.getClassTime());
        existingClass.setClassStatus(updatedClass.getClassStatus());
        existingClass.setTeacherImg(updatedClass.getTeacherImg());
        return subjectDao.save(existingClass);
    }

    // Delete a class by ID
    public void deleteClass(Long teacherId) {
        subjectDao.deleteById(teacherId);
    }
}
