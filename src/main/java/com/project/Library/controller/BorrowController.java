package com.project.Library.controller;


import com.project.Library.dto.BorrowBookDTO;
import com.project.Library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping("/borrow/{book_id}/patron/{patron_id}")
    public ResponseEntity<?> borrowBook(@PathVariable(value="book_id") int book_id , @PathVariable(value="patron_id") int patron_id ){

        try {
            borrowService.borrowBook(book_id,patron_id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Book Borrow Successfully");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }


    }

    @PutMapping("/return/{book_id}/patron/{patron_id}")
    public  ResponseEntity<?> returnBook(@PathVariable(value="book_id") int book_id , @PathVariable(value="patron_id") int patron_id ){
       try {
           borrowService.returnBook(book_id,patron_id);
           Map<String, String> response = new HashMap<>();
           response.put("message", "Book returned Successfully");
           return ResponseEntity.status(HttpStatus.OK).body(response);
       }
         catch (Exception e) {
             Map<String, String> response = new HashMap<>();
             response.put("message", e.getMessage());
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
         }

    }

}