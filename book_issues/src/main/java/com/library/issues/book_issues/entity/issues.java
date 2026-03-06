package com.library.issues.book_issues.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id",nullable = false,unique = true)
    private Long issueId;
    @Column(name = "book_id",nullable = false)
    private Long bookId;
    @Column(name = "user_id",nullable = false)
    private Long userId;
    @Column(name = "issue_date",nullable = false)
    private String issueDate;
    @Column(name = "return_date")
    private String returnDate;
    @Column(name = "status",nullable = false,columnDefinition = "VARCHAR(20) DEFAULT 'ISSUED'")
    private String status="ISSUED";
}