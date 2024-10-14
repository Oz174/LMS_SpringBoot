package com.project.Library.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name="borrow_record")
@IdClass(BorrowId.class)
@Data
@NoArgsConstructor
public class Borrow {


    @Id
    @ManyToOne
    @JoinColumn(name = "patron_id", nullable = false)
    private Patron patron;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;



    @Id
    @Column(name="borrow_date", nullable=false)
    private LocalDate borrow_date;


    @Column(name="return_date")
    private LocalDate return_date;



    public Borrow(Patron patron, Book book, LocalDate borrow_date, LocalDate return_date) {
        this.patron = patron;
        this.book = book;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
    }





}