package com.jpa.one2many.books;

import com.jpa.one2many.books.entity.Book;
import com.jpa.one2many.books.entity.Page;
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
        //Book book = new Book("Java", "Vincent", "123");
        //service.getBooksRepository().save(book);
        
        Book book = service.getBooksRepository().findById(1L).orElse(null);
        if(book != null) {
            //Page p1 = new Page(1, "認識 Java", "一", book);
            // service.getPagesRepository().save(p1);
            
            Page p2 = new Page(10, "Java基礎語法", "二", book);
            Page p3 = new Page(30, "Java資料結構", "三", book);
            service.getPagesRepository().save(p2);
            service.getPagesRepository().save(p3);
        }
    }

}
