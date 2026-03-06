package com.learningmodule.spring_boot_application.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learningmodule.spring_boot_application.Exceptions.StudentNotFoundException;
import com.learningmodule.spring_boot_application.entity.Student;
import com.learningmodule.spring_boot_application.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student saveStudentDetails(@RequestBody Student student) {
        return studentService.saveStudentDetails(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{SID}")
    public Student getStudentById(@PathVariable("SID") Long studentId) throws StudentNotFoundException {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/students/{SID}")
    public Student updateStudentDetails(@PathVariable("SID") Long studentId, @RequestBody Student student) {
        return studentService.updateStudentDetails(studentId,student);
    }

    @DeleteMapping("/students/{SID}")
    public String deleteStudentById(@PathVariable("SID") Long studentId) {
        studentService.deleteStudentById(studentId);
        return "Student Deleted Successfully";  
    }

    @GetMapping("/students/name/{name}")
    public List<Student> getStudentsByName(@PathVariable("name") String studentName){
        return studentService.getStudentsByName(studentName);
    }
}
