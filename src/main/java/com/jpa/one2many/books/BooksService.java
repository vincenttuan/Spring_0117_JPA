package com.jpa.one2many.books;

import com.jpa.one2many.teach.*;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("booksService")
public class BooksService {
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private PageRepository pageRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public PageRepository getPageRepository() {
        return pageRepository;
    }

    
    
    
    
}
