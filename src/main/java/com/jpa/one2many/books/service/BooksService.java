package com.jpa.one2many.books.service;

import com.jpa.one2many.books.dao.BooksRepository;
import com.jpa.one2many.books.dao.PagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("booksService")
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private PagesRepository pagesRepository;

    public BooksRepository getBooksRepository() {
        return booksRepository;
    }

    public PagesRepository getPagesRepository() {
        return pagesRepository;
    }
    
    
}
