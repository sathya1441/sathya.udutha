package com.library.books.books_service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.books.books_service.entity.Books;
import com.library.books.books_service.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public String insertIntoBooksTable(Books books) {
        bookRepository.save(books);
        return "Book added successfully"; 
    }

    public List<Books> fetchAllBooks() {
        return bookRepository.findAll();
    }

    public Books fetchBookById(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    public String updateBooksTable(Long bookId, Books books) {
        Books existingBook = bookRepository.findById(bookId).get();
        if(books.getTitle() != null) {
            existingBook.setTitle(books.getTitle());
        }
        if(books.getGenre() != null) {
            existingBook.setGenre(books.getGenre());
        }
        if(books.getBookPrice() != null) {
            existingBook.setBookPrice(books.getBookPrice());
        }
        bookRepository.save(existingBook);
        return "Book updated successfully";
    }

}