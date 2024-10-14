package com.project.Library.service;


import java.util.List;

public interface BorrowService {
    boolean borrowBook(int book_id , int patron_id , LocalDate borrow_date);
    boolean returnBook(int book_id , int patron_id , LocalDate return_date);
}
