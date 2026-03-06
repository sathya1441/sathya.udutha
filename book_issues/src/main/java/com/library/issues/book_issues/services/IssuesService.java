package com.library.issues.book_issues.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.library.issues.book_issues.ValueObjects.Books;
import com.library.issues.book_issues.ValueObjects.RequestTemplateVO;
import com.library.issues.book_issues.entity.issues;
import com.library.issues.book_issues.repository.IssuesRepository;

@Service
public class IssuesService {

    @Autowired
    private IssuesRepository issuesRepository; 

    @Autowired
    private RestTemplate restTemplate;

    public List<issues> getAllIssuedBooks(issues issue) {
        return issuesRepository.findAll();
    }

    public String issueBook(issues issue) {
        issuesRepository.save(issue);
        return "Book issued successfully!";
    }

    public RequestTemplateVO getIssuesWithBooks(Long issueId) {
        RequestTemplateVO vo = new RequestTemplateVO();
        issues issue = issuesRepository.findById(issueId).get();
        Books book = restTemplate.getForObject("http://localhost:9002/books/"+issue.getBookId(), Books.class);
        vo.setIssue(issue);
        vo.setBook(book);
        return vo;
    }
}
