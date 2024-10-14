package com.project.Library.service;

public interface BorrowService {
    boolean borrowBook(int book_id , int patron_id );
    boolean returnBook(int book_id , int patron_id);
}
