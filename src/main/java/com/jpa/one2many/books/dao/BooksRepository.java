package com.jpa.one2many.books.dao;

import com.jpa.one2many.books.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book, Long>{
    
}
