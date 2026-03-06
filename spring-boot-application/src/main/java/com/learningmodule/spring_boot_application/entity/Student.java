package com.learningmodule.spring_boot_application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String studentName;
    private String schoolLocation;
    private String studentGrade;

public Long getStudentId() {
    return studentId;
}

public void setStudentId(Long studentId) {
    this.studentId = studentId;
}

public String getStudentName() {
    return studentName;
}

public void setStudentName(String studentName) {
    this.studentName = studentName;
}

public String getSchoolLocation() {
    return schoolLocation;
}

public void setSchoolLocation(String schoolLocation) {
    this.schoolLocation = schoolLocation;
}

public String getStudentGrade() {
    return studentGrade;
}

public void setStudentGrade(String studentGrade) {
    this.studentGrade = studentGrade;
}

public Student(Long studentId, String studentName, String schoolLocation, String studentGrade) {
    this.studentId = studentId;
    this.studentName = studentName;
    this.schoolLocation = schoolLocation;
    this.studentGrade = studentGrade;
}

public Student() {
}

@Override
public String toString() {
    return "Student [studentId=" + studentId + ", studentName=" + studentName + ", schoolLocation=" + schoolLocation
            + ", studentGrade=" + studentGrade + "]";
}

}