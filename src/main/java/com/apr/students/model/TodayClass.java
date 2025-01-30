package com.apr.students.model;

import jakarta.persistence.*;

@Entity
public class TodayClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long teacherId;
    private String teacherName;
    private String todaySubject;
    private String classTime;
    private String classStatus;

    @Lob
    private byte[] teacherImg;

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTodaySubject() {
        return todaySubject;
    }

    public void setTodaySubject(String todaySubject) {
        this.todaySubject = todaySubject;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }

    public byte[] getTeacherImg() {
        return teacherImg;
    }

    public void setTeacherImg(byte[] teacherImg) {
        this.teacherImg = teacherImg;
    }
}
