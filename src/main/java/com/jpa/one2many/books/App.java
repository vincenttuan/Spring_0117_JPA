package com.jpa.one2many.books;

import com.jpa.one2many.books.service.BooksService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    static BooksService service;

    static {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.jpa");
        appContext.refresh();
        service = (BooksService) appContext.getBean("booksService");
    }

    public static void main(String[] args) throws Exception {
        
    }

}
