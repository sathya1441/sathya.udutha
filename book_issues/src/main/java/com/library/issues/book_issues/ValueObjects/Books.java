package com.library.issues.book_issues.ValueObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private Long bookId;
    private String title;
    private String genre;
    private Long bookPrice;
}
