package com.project.Library.service;
import com.project.Library.dto.BorrowBookDTO;

import java.util.List;

public interface BorrowService {
    boolean borrowBook(int book_id , int patron_id , BorrowBookDTO BorrowBookDTO);
    boolean returnBook(int book_id , int patron_id);
}
