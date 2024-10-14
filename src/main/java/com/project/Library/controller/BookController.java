package com.project.Library.controller;


import com.project.Library.dto.BookDTO;
import com.project.Library.dto.BookSavedDTO;
import com.project.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody BookSavedDTO bookSavedDTO){

        try {
            return  ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(bookSavedDTO));
        }
        catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

    }

    @GetMapping
    public  ResponseEntity<?> getAllBooks(){

        try {
            List<BookDTO> all_books = bookService.getAllBooks();
            return ResponseEntity.status(HttpStatus.OK).body(all_books);
        }
        catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }



    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getBookData(@PathVariable(value="id") int id){
        BookDTO bookDTO = bookService.getBookData(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookDTO);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<BookDTO>  updateBook(@PathVariable(value="id") int id,@RequestBody BookSavedDTO bookSavedDTO){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id , bookSavedDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") int id) {
        bookService.deleteBook(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Book Deleted Successfully");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
