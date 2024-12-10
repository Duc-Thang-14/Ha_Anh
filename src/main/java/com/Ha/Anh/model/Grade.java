package com.Ha.Anh.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Grade")
public class Grade {

    @EmbeddedId
    private GradeId id; // Using GradeId as primary key

    @Column(name = "RegularGrade1", nullable = false)
    private Double regularGrade1;

    @Column(name = "RegularGrade2", nullable = false)
    private Double regularGrade2;

    @Column(name = "FinalGrade", nullable = false)
    private Double finalGrade;

    @Column(name = "TotalGrade", nullable = false)
    private Double totalGrade;

    @Column(name = "AbsentHours")
    private Integer absentHours;

    @Column(name = "ExamCondition")
    private String examCondition;

    @ManyToOne
    @MapsId("studentID") // Mapping primary key `studentID` from GradeId
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID", nullable = false)
    private Student student;

    @ManyToOne
    @MapsId("subjectID") // Mapping primary key `subjectID` from GradeId
    @JoinColumn(name = "SubjectID", referencedColumnName = "SubjectID", nullable = false)
    private Subject subject;

    // Calculate total grade before persistence and update
    @PrePersist
    @PreUpdate
    public void calculateTotalGrade() {
        this.totalGrade = (regularGrade1 * 0.15) + (regularGrade2 * 0.15) + (finalGrade * 0.7);
    }

    // Getters and Setters
    public GradeId getId() {
        return id;
    }

    public void setId(GradeId id) {
        this.id = id;
    }

    public Double getRegularGrade1() {
        return regularGrade1;
    }

    public void setRegularGrade1(Double regularGrade1) {
        this.regularGrade1 = regularGrade1;
    }

    public Double getRegularGrade2() {
        return regularGrade2;
    }

    public void setRegularGrade2(Double regularGrade2) {
        this.regularGrade2 = regularGrade2;
    }

    public Double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public Double getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(Double totalGrade) {
        this.totalGrade = totalGrade;
    }

    public Integer getAbsentHours() {
        return absentHours;
    }

    public void setAbsentHours(Integer absentHours) {
        this.absentHours = absentHours;
    }

    public String getExamCondition() {
        return examCondition;
    }

    public void setExamCondition(String examCondition) {
        this.examCondition = examCondition;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
