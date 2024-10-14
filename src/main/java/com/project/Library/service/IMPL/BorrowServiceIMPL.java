package com.project.Library.service.IMPL;

import com.project.Library.dto.BorrowBookDTO;
import com.project.Library.entity.Borrow;
import com.project.Library.repo.BorrowRepo;
import com.project.Library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceIMPL implements BorrowService {

    @Autowired
    private BorrowRepo borrowRepo;

    @Override
    boolean borrowBook(int book_id , int patron_id , BorrowBookDTO borrowBookDTO){
        // logish
        // 1- check if book exist and user exists (this should be enforced by fk constraint)
        
        // 2-  for the desired book to borrow , look for maximum return date , if borrow_date is the 
        // same or above , safely borrow the book (it shouldn't matter if it's a future borrow)

        // save book_id , patron_id , borrow_date and return date 
        // my question : the JPA OneToMany will join and store id ? or reference to the book ? 



    }

    @Override
    boolean returnBook(int book_id , int patron_id){
        // logish 

        // 1- look for the book and user if they exist (bardo should be enforced y3ny by fk)
        // 2- check if this (book_id,patron_id) combination exist 
        // another way to put it : howa el user eli byrg3 el ktab da bta3o aslun wla laa 

        // 3- the current return date will be the immediate date once the api has called this function 
        // it is left like this in case of fine application on delay 

    }
}
