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
    }

    @Override
    boolean returnBook(int book_id , int patron_id){

    }
}
