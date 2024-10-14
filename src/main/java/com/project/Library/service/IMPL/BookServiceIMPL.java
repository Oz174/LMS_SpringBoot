package com.project.Library.service.IMPL;

import com.project.Library.dto.BookDTO;
import com.project.Library.dto.BookSavedDTO;
import com.project.Library.entity.Book;
import com.project.Library.repo.BookRepo;
import com.project.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public String addBook(BookSavedDTO bookSavedDTO) {
        Book book = new Book(
                bookSavedDTO.getTitle(),
                bookSavedDTO.getAuthor_name(),
        );
        bookRepo.save(book);
        return "Book Added Successfully";
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> allbooks = bookRepo.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();

        for (Book book:allbooks){
            BookDTO bookDTO = new BookDTO(
                    book.getBook_id(),
                    book.getTitle(),
                    book.getAuthor_name(),
            );
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    @Override
    public String updateBook(int id, BookSavedDTO bookUpdateDTO) {
        // check if there's a book with the id that exists

        if (bookRepo.existsById(id)){
            Book book = bookRepo.getReferenceById(id);
            book.setTitle(bookUpdateDTO.getTitle());
            book.setAuthor_name(bookUpdateDTO.getAuthor_name());
            bookRepo.save(book);
            return "Update Successful!";

        }
        else{
            System.out.println("Book ID Doesn't Exist !!");
            return "Entry doesn't exist!";
        }

    }

    @Override
    public String deleteBook(int id) {
        if (bookRepo.existsById(id)){
            bookRepo.deleteById(id);
            return "Deleted Successfully";
        }
        else{
             return "Book Doesn't Exist" ;
        }
    }

    @Override
    public BookDTO getBookData(int id) {
        Book book = bookRepo.getReferenceById(id);
        BookDTO bookDTO = new BookDTO(
                book.getBook_id(),
                book.getTitle(),
                book.getAuthor_name(),
        );
        return bookDTO;
    }
}
