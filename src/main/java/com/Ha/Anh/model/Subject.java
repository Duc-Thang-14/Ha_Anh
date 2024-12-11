package com.Ha.Anh.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Subject")
public class Subject {

    @Id
    @Column(name = "SubjectID")
    private String subjectID; // Changed to String

    @Column(name = "SubjectName", nullable = false)
    private String subjectName;

    @Column(name = "Credits", nullable = false)
    private Integer credits;

    @Column(name = "ReleaseDate", nullable = false)
    private String releaseDate;

    @Column(name = "Lecturer", nullable = false)
    private String lecturer;

    @Column(name = "TrainingUnit", nullable = false)
    private String trainingUnit;

    @Column(name = "EnglishName", nullable = false)
    private String englishName;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> gradeList;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> scheduleList;

    // Getters and Setters
    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getTrainingUnit() {
        return trainingUnit;
    }

    public void setTrainingUnit(String trainingUnit) {
        this.trainingUnit = trainingUnit;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
