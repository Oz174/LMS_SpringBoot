package com.project.Library.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class BorrowId implements Serializable {
    private Patron patron;
    private Book book;
    private LocalDate borrow_date;

}
