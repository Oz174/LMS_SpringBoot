package com.project.Library.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="book")
public class Book {

    // data members and columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id",length=11)
    private int book_id ;

    @Column(name="title", length=50,nullable = false, unique = true)
    private String title;

    @Column(name="author_name", length = 50,nullable = false)
    private String author_name;

    @Column(name="is_borrowed", length=1,nullable = false)
    private boolean borrowed;


    public Book(int book_id, String title, String author_name, boolean borrowed) {
        this.book_id = book_id;
        this.title = title;
        this.author_name = author_name;
        this.borrowed = borrowed;
    }

    public Book(String title, String author_name, boolean borrowed) {
        this.title = title;
        this.author_name = author_name;
        this.borrowed = borrowed;
    }

    public Book() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author_name='" + author_name + '\'' +
                ", borrowed=" + borrowed +
                '}';
    }


}
