package com.jpa.one2many.books.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pages")
public class Page implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;     // 頁數
    private String content; // 內容
    private String chapter; // 章節

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // optional = false (inner join), optional = true (left join) 預設
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public Page() {
    }

    public Page(int number, String content, String chapter, Book book) {
        this.number = number;
        this.content = content;
        this.chapter = chapter;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
