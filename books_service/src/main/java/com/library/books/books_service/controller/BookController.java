package com.library.books.books_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.books_service.entity.Books;
import com.library.books.books_service.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @PostMapping("/add")
    public String addBook(@RequestBody Books books) {
        return bookService.insertIntoBooksTable(books);
    }

    @GetMapping("/")
    public List<Books> getAllBooks(){
        return bookService.fetchAllBooks();
    }

    @GetMapping("/{id}")
    public Books getBooksById(@PathVariable("id") Long bookId){
        return bookService.fetchBookById(bookId);
    }

    @PutMapping("/{id}")
    public String updateBooksDetails(@PathVariable("id") Long bookId, @RequestBody Books books) {
        return bookService.updateBooksTable(bookId,books);
    }
}
