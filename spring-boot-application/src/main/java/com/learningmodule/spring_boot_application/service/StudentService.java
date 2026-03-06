package com.learningmodule.spring_boot_application.service;

import java.util.List;

import com.learningmodule.spring_boot_application.Exceptions.StudentNotFoundException;
import com.learningmodule.spring_boot_application.entity.Student;

public interface StudentService {

    Student saveStudentDetails(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long studentId) throws StudentNotFoundException;

    Student updateStudentDetails(Long studentId, Student student);

    void deleteStudentById(Long studentId);

    List<Student> getStudentsByName(String studentName);

}
