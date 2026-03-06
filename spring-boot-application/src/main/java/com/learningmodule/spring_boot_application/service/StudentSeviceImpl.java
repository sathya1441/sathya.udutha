package com.learningmodule.spring_boot_application.service;

import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningmodule.spring_boot_application.Exceptions.StudentNotFoundException;
import com.learningmodule.spring_boot_application.entity.Student;
import com.learningmodule.spring_boot_application.repository.StudentRepository;

@Service
public class StudentSeviceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudentDetails(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) throws StudentNotFoundException {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        
        if(studentOpt.isEmpty()) {
            throw new StudentNotFoundException("Student not found for the id "+studentId);
        }
        return studentOpt.get();
    }

    @Override
    public Student updateStudentDetails(Long studentId, Student student) {
        Student existingStudent = studentRepository.findById(studentId).get();
        if(Objects.nonNull(student.getStudentName())&& !"".equalsIgnoreCase(student.getStudentName())) {
            existingStudent.setStudentName(student.getStudentName());
        }
        if(Objects.nonNull(student.getSchoolLocation())&& !"".equalsIgnoreCase(student.getSchoolLocation())) {
            existingStudent.setSchoolLocation(student.getSchoolLocation());
        }
        if(Objects.nonNull(student.getStudentGrade())&& !"".equalsIgnoreCase(student.getStudentGrade())) {
            existingStudent.setStudentGrade(student.getStudentGrade());
        }
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> getStudentsByName(String studentName) {
        return List.of(studentRepository.findByStudentName(studentName));
    }

}
