package com.project.Library.entity;

import com.project.Library.entity.Book;

import com.project.Library.entity.Patron;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="borrow_record")
public class Borrow {

    // A patron can borrow multiple books , but a single book can only be borrowed by 1 patron
    // this means that 1 patron can have many books 
    // 1 book can only have one owner 
    // but a book can be reborrwed 
    // f ana b2ees 3l record ? wla 3la general scale ? 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int record_id; 

    // will need to assign mapping 
    private Set<Book> borrowed_books = new Hashset<>();

    private Set<Patron> borrowing_patrons = new Hashset<>();

    @Column(name="borrow_date",nullable=false)
    private LocalDate borrow_date; 

    @Column(name="return_date", nullable=false)
    private LocalDate return_date; 

    // constructor with all 

    Borrow(){

    }

    Borrow(LocalDate borrow_date , LocalDate return_date){
        this.borrow_date = borrow_date;
        this.return_date = return_date;
    }

    //TODO: setters and getters

}