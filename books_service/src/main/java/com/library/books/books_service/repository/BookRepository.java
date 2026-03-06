package com.library.books.books_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.books.books_service.entity.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Long>  {

}
