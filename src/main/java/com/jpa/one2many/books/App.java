package com.jpa.one2many.books;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// https://attacomsian.com/blog/spring-data-jpa-one-to-many-mapping
public class App {

    static BooksService service;

    static {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.jpa");
        appContext.refresh();
        service = (BooksService) appContext.getBean("booksService");
    }

    public static void main(String[] args) throws Exception {
        // create a new book
        //Book book = new Book("Java 101", "John Doe", "123456");
        Book book = service.getBookRepository().findById(1L).get();
        System.out.println(service.getBookRepository().findAll());
        // save the book
        //service.getBookRepository().save(book);
        // create and save new pages
        //service.getPageRepository().save(new Page(1, "Introduction contents", "Introduction", book));
        //service.getPageRepository().save(new Page(65, "Java 8 contents", "Java 8", book));
        //service.getPageRepository().save(new Page(95, "Concurrency contents", "Concurrency", book));

    }

}
