package com.project.Library.service.IMPL;

import com.project.Library.entity.Book;
import com.project.Library.entity.Borrow;
import com.project.Library.entity.BorrowId;
import com.project.Library.entity.Patron;
import com.project.Library.repo.BookRepo;
import com.project.Library.repo.BorrowRepo;
import com.project.Library.repo.PatronRepo;
import com.project.Library.service.BorrowService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowServiceIMPL implements BorrowService {

    @Autowired
    private BorrowRepo borrowRepo;
    @Autowired
    private PatronRepo patronRepo;
    @Autowired
    private BookRepo bookRepo;


    @Override
    @Transactional
    public boolean borrowBook(int book_id, int patron_id){
        // TODO: logish
        // 1- check if book exist and user exists (this should be enforced by fk constraint)
        
        // 2-  for the desired book to borrow , look for maximum return date if exists any records , if borrow_date is the 
        // same or above , safely borrow the book (it shouldn't matter if it's a future borrow)

        // save book_id , patron_id , borrow_date and return date 
        // my question : the JPA OneToMany will join and store id ? or reference to the book ? 

        Patron patron = patronRepo.findById(patron_id).orElseThrow(
                () -> new RuntimeException("Patron not found")
        );
        Book book = bookRepo.findById(book_id).orElseThrow(
                () -> new RuntimeException("Book not found")
        );

        if (book.isBorrowed()){
            throw new RuntimeException("Book is already borrowed");
        }

        Borrow borrow = new Borrow(patron,book, LocalDate.now(),null);

        borrowRepo.save(borrow);
        book.setBorrowed(true);
        bookRepo.save(book);

        return true;

    }

    @Override
    @Transactional
    public boolean returnBook(int book_id, int patron_id){
        // TODO: logish 

        // 1- look for the book and user if they exist (bardo should be enforced y3ny by fk)
        // 2- check if this (book_id,patron_id) combination exist 
        // another way to put it : howa el user eli byrg3 el ktab da bta3o aslun wla laa 

        // 3- the current return date will be the immediate date once the api has called this function 
        // it is left like this in case of fine application on delay

        Patron patron = patronRepo.findById(patron_id).orElseThrow(
                () -> new RuntimeException("Patron not found")
        );
        Book book = bookRepo.findById(book_id).orElseThrow(
                () -> new RuntimeException("Book not found")
        );

        if (!book.isBorrowed()){
            throw new RuntimeException("Book is not borrowed");
        }
        List<Borrow> borrows = borrowRepo.checkBorrow( patron_id,book_id);
        System.out.println(borrows);
        if (borrows.isEmpty()){
            throw new RuntimeException("Book is not borrowed by this patron");
        }
        Borrow borrowRecord=borrows.get(0);
        borrowRecord.setReturn_date(LocalDate.now());
        borrowRepo.save(borrowRecord);
        book.setBorrowed(false);
        bookRepo.save(book);

        return true;

    }
}
