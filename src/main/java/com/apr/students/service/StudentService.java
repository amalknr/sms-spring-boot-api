package com.apr.students.service;

import com.apr.students.dao.StudentDao;
import com.apr.students.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Prefer @Service over @Component for service classes
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Students addStudent(Students students) {
        return studentDao.save(students);
    }

    public List<Students> getStudents() {
        return studentDao.findAll();
    }

    public Students getStudent(int studentId) {
        return studentDao.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student with ID " + studentId + " not found"));
    }

    public Students updateStudent(int studentId, Students student) {
        if (!studentDao.existsById(studentId)) {
            throw new RuntimeException("Student with ID " + studentId + " not found");
        }
        student.setStudentId(studentId);
        return studentDao.save(student);
    }

    public void deleteStudent(int studentId) {
        if (!studentDao.existsById(studentId)) {
            throw new RuntimeException("Student with ID " + studentId + " not found");
        }
        studentDao.deleteById(studentId);
    }
}
