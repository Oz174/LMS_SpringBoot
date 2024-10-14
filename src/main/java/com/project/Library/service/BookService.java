package com.project.Library.service;

import com.project.Library.dto.BookDTO;
import com.project.Library.dto.BookSavedDTO;

import java.util.List;

public interface BookService {
    BookDTO addBook(BookSavedDTO bookSavedDTO);

    List<BookDTO> getAllBooks();

    BookDTO updateBook(int id, BookSavedDTO bookSavedDTO);

    boolean deleteBook(int id);

    BookDTO getBookData(int id);
}
