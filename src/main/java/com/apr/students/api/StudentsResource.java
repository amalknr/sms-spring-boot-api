package com.apr.students.api;

import com.apr.students.model.Students;
import com.apr.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsResource {

    @Autowired
    private StudentService studentsService;

    // Add a new student
    @PostMapping(consumes = {"multipart/form-data"})
    public Students addStudentWithPhoto(
            @RequestParam("studentName") String studentName,
            @RequestParam("studentRoll") int studentRoll,
            @RequestParam("studentEmail") String studentEmail,
            @RequestParam("studentDepartment") String studentDepartment,
            @RequestParam("studentSemester") String studentSemester,
            @RequestParam("photo") MultipartFile photo
    ) throws Exception {
        // Create a new Students object and set its fields
        Students student = new Students();
        student.setStudentName(studentName);
        student.setStudentRoll(studentRoll);
        student.setStudentEmail(studentEmail);
        student.setStudentDepartment(studentDepartment);
        student.setStudentSemester(studentSemester);
        student.setPhoto(photo.getBytes()); // Convert file to byte array and set it

        // Save the student and return the result
        return studentsService.addStudent(student);
    }

    // Get all students
    @GetMapping
    public List<Students> getAllStudents() {
        return studentsService.getStudents();
    }

    // Get a specific student by ID
    @GetMapping("/{studentId}")
    public Students getStudent(@PathVariable("studentId") int studentId) {
        return studentsService.getStudent(studentId);
    }

    // Update a student record
    // Update a student record with a photo
    @PutMapping(value = "/{studentId}", consumes = {"multipart/form-data"})
    public Students updateStudentWithPhoto(
            @PathVariable("studentId") int studentId,
            @RequestParam("studentName") String studentName,
            @RequestParam("studentRoll") int studentRoll,
            @RequestParam("studentEmail") String studentEmail,
            @RequestParam("studentDepartment") String studentDepartment,
            @RequestParam("studentSemester") String studentSemester,
            @RequestParam(value = "photo", required = false) MultipartFile photo // Optional photo
    ) throws Exception {
        // Fetch the existing student record
        Students existingStudent = studentsService.getStudent(studentId);
        if (existingStudent == null) {
            throw new IllegalArgumentException("Student with ID " + studentId + " not found");
        }

        // Update fields
        existingStudent.setStudentName(studentName);
        existingStudent.setStudentRoll(studentRoll);
        existingStudent.setStudentEmail(studentEmail);
        existingStudent.setStudentDepartment(studentDepartment);
        existingStudent.setStudentSemester(studentSemester);

        // Update photo if provided
        if (photo != null && !photo.isEmpty()) {
            existingStudent.setPhoto(photo.getBytes());
        }

        // Save and return the updated student
        return studentsService.updateStudent(studentId, existingStudent);
    }



    // Delete a student record
    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Return HTTP 204
    public void deleteStudent(@PathVariable int studentId) {
        studentsService.deleteStudent(studentId);
    }
}
