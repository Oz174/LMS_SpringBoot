package com.project.Library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name="book")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
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


    @Column(name="borrowed", columnDefinition = "boolean default false")
    private boolean borrowed = false;



    public Book(String title, String author_name, boolean borrowed ) {
        this.title = title;
        this.author_name = author_name;
        this.borrowed = borrowed;

    }



}
