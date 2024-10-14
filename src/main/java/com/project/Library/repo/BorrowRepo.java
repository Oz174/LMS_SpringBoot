package com.project.Library.repo;

import com.project.Library.entity.Borrow;
import com.project.Library.entity.BorrowId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BorrowRepo extends JpaRepository<Borrow, BorrowId> {


    @Query("SELECT b FROM Borrow b WHERE b.patron.patron_id = :patronId AND b.book.book_id = :bookId AND b.return_date IS NULL")
    List<Borrow> checkBorrow( int patronId,  int bookId);

}
