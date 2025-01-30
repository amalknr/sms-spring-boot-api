package com.apr.students.model;

import jakarta.persistence.*;

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String studentName;
    private String StudentDepartment;
    private int studentRoll;
    private String studentEmail;
    private String studentSemester;

    @Lob
    private byte[] photo;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDepartment() {
        return StudentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        StudentDepartment = studentDepartment;
    }

    public int getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentSemester() {
        return studentSemester;
    }

    public void setStudentSemester(String studentSemester) {
        this.studentSemester = studentSemester;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
