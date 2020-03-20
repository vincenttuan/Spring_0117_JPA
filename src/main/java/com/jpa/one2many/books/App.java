package com.jpa.one2many.books;

import com.jpa.one2many.books.entity.Book;
import com.jpa.one2many.books.entity.Page;
import com.jpa.one2many.books.service.BooksService;
import java.util.Set;
import java.util.stream.StreamSupport;
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
        //save();
        //System.out.println(service.getBooksRepository().findByISBN("123"));
        //System.out.println(service.getBooksRepository().findByAuthor("Vincent"));
        
//        Set<Page> pages = service.getBooksRepository().findByISBN("123").getPages();
//        System.out.println(pages);
//        pages.stream().forEach(System.out::println);
        
        // 尋找有"基礎", "演算" 的書名
        StreamSupport.stream(service.getPagesRepository().findAll().spliterator(), false)
                .filter(p -> p.getContent().contains("基礎") || p.getContent().contains("演算"))
                .forEach(p -> System.out.println(p.getBook().getTitle()));
                
        
    }
    
    public static void save() {
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
        
        service.getPagesRepository().save(new Page(1, "認識 Python", "一", book2));
        service.getPagesRepository().save(new Page(15, "Python 基礎語法", "二", book2));
        service.getPagesRepository().save(new Page(35, "Python 演算語法", "三", book2));
    }

}
