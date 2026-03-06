package com.library.issues.book_issues.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.issues.book_issues.ValueObjects.RequestTemplateVO;
import com.library.issues.book_issues.entity.issues;
import com.library.issues.book_issues.services.IssuesService;

@RestController
@RequestMapping("/issues")
public class IssuesController {

    @Autowired
    private IssuesService issuesService;

    @GetMapping
    public List<issues> getAllIssues(@RequestBody issues issue) {
        return issuesService.getAllIssuedBooks(issue);
    }

    @PostMapping("/book")  // Changed from /issueBook to make it more RESTful
    public String issueBook(@RequestBody issues issue) {
        return issuesService.issueBook(issue);
    }

    @GetMapping("/{id}")  // Changed to /detail/{id} to avoid conflict
    public RequestTemplateVO getIssuesAndBooksDetails(@PathVariable("id") Long issueId) {
        return issuesService.getIssuesWithBooks(issueId);
    }
}