package com.jpa.one2many.books;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByIsbn(String isbn);
}