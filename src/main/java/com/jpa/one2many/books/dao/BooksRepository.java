package com.jpa.one2many.books.dao;

import com.jpa.one2many.books.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BooksRepository extends CrudRepository<Book, Long>{
    @Query("SELECT b FROM Book b WHERE b.isbn=:isbn")
    Book findByISBN(@Param("isbn") String isbn);
    
    @Query("SELECT b FROM Book b WHERE b.author=:author")
    List<Book> findByAuthor(@Param("author") String author);
    
}
