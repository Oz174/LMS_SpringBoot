package com.project.Library.controller;


import com.project.Library.dto.BorrowBookDTO;
import com.project.Library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping("/{book_id}/borrow/{patron_id}")
    public String borrowBook(@PathVariable(value="book_id") int book_id , @PathVariable(value="patron_id") patron_id , @RequestedBody BorrowBookDTO borrowBookDTO){
        return borrowService.borrowBook(book_id,patron_id,borrowBookDTO);
    }

    @PostMapping("/{book_id}/return/{patron_id}")
    public String returnBook(@PathVariable(value="book_id") int book_id , @PathVariable(value="patron_id") patron_id ){
        return borrowService.returnBook(book_id,patron_id);
    }

}