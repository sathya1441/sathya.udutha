package com.library.issues.book_issues.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.issues.book_issues.entity.issues;

public interface IssuesRepository extends JpaRepository<issues, Long> {

}
