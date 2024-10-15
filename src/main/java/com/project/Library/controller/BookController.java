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
    public ResponseEntity<?> addBook(@RequestBody BookSavedDTO bookSavedDTO){

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
    public ResponseEntity<?> getBookById(@PathVariable(value = "id") int id) {
        try {
            BookDTO book = bookService.getBookData(id);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable(value = "id") int id, @RequestBody BookSavedDTO bookSavedDTO) {
        try {
            BookDTO book = bookService.updateBook(id, bookSavedDTO);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") int id) {
        try {
            bookService.deleteBook(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Book deleted successfully");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
