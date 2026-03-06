package com.library.issues.book_issues.ValueObjects;

import com.library.issues.book_issues.entity.issues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestTemplateVO {
    private issues issue;
    private Books book;
}
