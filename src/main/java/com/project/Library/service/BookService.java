package com.project.Library.service;

import com.project.Library.dto.BookDTO;
import com.project.Library.dto.BookSavedDTO;

import java.util.List;

public interface BookService {
    String addBook(BookSavedDTO bookSavedDTO);

    List<BookDTO> getAllBooks();

    String updateBook(int id, BookSavedDTO bookSavedDTO);

    String deleteBook(int id);

    BookDTO getBookData(int id);
}
