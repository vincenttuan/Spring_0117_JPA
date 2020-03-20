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
        
        Book book = new Book("Java", "Vincent", "123");
        Book book2 = new Book("Python", "Anita", "456");
        
        service.getBooksRepository().save(book);
        service.getBooksRepository().save(book2);
        
        Page p1 = new Page(1, "認識 Java", "一", book);
        Page p2 = new Page(10, "Java 基礎語法", "二", book);
        Page p3 = new Page(30, "Java 資料結構", "三", book);
        service.getPagesRepository().save(p1);
        service.getPagesRepository().save(p2);
        service.getPagesRepository().save(p3);
        
        Page p4 = new Page(1, "認識 Python", "一", book2);
        Page p5 = new Page(15, "Python 基礎語法", "二", book2);
        Page p6 = new Page(35, "Python 演算語法", "三", book2);
        service.getPagesRepository().save(p4);
        service.getPagesRepository().save(p5);
        service.getPagesRepository().save(p6);

    }

}
