package com.jpa.one2many.books.dao;

import com.jpa.one2many.books.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface PagesRepository extends CrudRepository<Book, Long>{
    
}
