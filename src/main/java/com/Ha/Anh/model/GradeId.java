package com.Ha.Anh.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GradeId implements Serializable {

    @Column(name = "StudentID", nullable = false)
    private String studentID; // Changed to String

    @Column(name = "SubjectID", nullable = false)
    private String subjectID;

    // Constructors
    public GradeId() {
    }

    public GradeId(String studentID, String subjectID) {
        this.studentID = studentID;
        this.subjectID = subjectID;
    }

    // Getters and Setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    // Override equals() and hashCode() to ensure integrity of primary key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeId gradeId = (GradeId) o;
        return Objects.equals(studentID, gradeId.studentID) &&
                Objects.equals(subjectID, gradeId.subjectID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, subjectID);
    }
}
