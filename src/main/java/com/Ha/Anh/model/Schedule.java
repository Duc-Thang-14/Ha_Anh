package com.Ha.Anh.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Schedule")
public class Schedule {

    @Id
    @Column(name = "ScheduleID")
    private String scheduleID; // Changed to String

    @Column(name = "ClassTime", nullable = false)
    private String classTime;

    @Column(name = "Location", nullable = false)
    private String location;

    @Column(name = "TeacherName", nullable = false)
    private String teacherName;

    @ManyToOne
    @JoinColumn(name = "SubjectID", referencedColumnName = "SubjectID", nullable = false)
    private Subject subject;

    // Getters and Setters
    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
