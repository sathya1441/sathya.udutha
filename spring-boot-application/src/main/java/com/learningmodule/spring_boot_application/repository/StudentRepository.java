package com.learningmodule.spring_boot_application.repository;

import org.springframework.stereotype.Repository;

import com.learningmodule.spring_boot_application.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByStudentName(String studentName);
}