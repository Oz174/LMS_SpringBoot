package com.project.Library.controller;


import com.project.Library.dto.BookDTO;
import com.project.Library.dto.BookSavedDTO;
import com.project.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/")
    public String saveBook(@RequestBody BookSavedDTO bookSavedDTO){
        String bookname = bookService.addBook(bookSavedDTO);
        return bookname;
    }

    @GetMapping("/")
    public List<BookDTO> getAllBooks(){
        List<BookDTO> all_books = bookService.getAllBooks();
        return all_books;
    }

    @GetMapping("/{id}")
    public BookDTO getBookData(@PathVariable(value="id") int id){
        BookDTO bookDTO = bookService.getBookData(id);
        return bookDTO;
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable(value="id") int id,@RequestBody BookSavedDTO bookSavedDTO){
        String bookname = bookService.updateBook(id , bookSavedDTO);
        return bookname;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable(value = "id") int id){
        String bookname = bookService.deleteBook(id);
        return bookname;
    }

}
