package com.project.Library.controller;

import com.project.Library.service.BookService;
import com.project.Library.dto.BookSavedDTO;
import com.project.Library.dto.BookDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookControllerTest {
    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testCreateBookSuccess() {
        String title = "Title";
        String author = "Author";

        // Create BookSavedDTO instance to simulate input
        BookSavedDTO bookSavedDTO = new BookSavedDTO(title, author);

        // Create expected BookDTO instance to simulate returned object
        BookDTO bookDTO = new BookDTO(1, title, author, false);

        // Mock addBook behavior to return the expected BookDTO
        when(bookService.addBook(bookSavedDTO)).thenReturn(bookDTO);

        // Call the addBook method on the controller
        ResponseEntity<?> response = bookController.addBook(bookSavedDTO);

        // Verify the HTTP status and response body
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(bookDTO, response.getBody());

        verify(bookService, times(1)).addBook(bookSavedDTO);
    }

    @Test
    void testCreateBookFailure() {
        String title = "Title";
        String author = "Author";

        // Create BookSavedDTO instance to simulate input
        BookSavedDTO bookSavedDTO = new BookSavedDTO(title, author);

        // Simulate an exception when trying to add the book
        when(bookService.addBook(bookSavedDTO)).thenThrow(new RuntimeException("Failed to create book"));

        // Call the addBook method on the controller
        ResponseEntity<?> response = bookController.addBook(bookSavedDTO);

        // Verify the HTTP status and response body
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertInstanceOf(Map.class, response.getBody());

        // Check that the error message matches what the service threw
        Map<String, String> responseBody = (Map<String, String>) response.getBody();
        assertEquals("Failed to create book", responseBody.get("message"));

        // Verify that the service method was called exactly once
        verify(bookService, times(1)).addBook(bookSavedDTO);
    }

    @Test
    void testGetBookByIdSuccess() {
        int bookId = 1;
        String title = "Title";
        String author = "Author";

        // Create expected BookDTO instance to simulate returned object
        BookDTO bookDTO = new BookDTO(bookId, title, author, false);

        // Mock getBookById behavior to return the expected BookDTO
        when(bookService.getBookData(bookId)).thenReturn(bookDTO);

        // Call the getBookById method on the controller
        ResponseEntity<?> response = bookController.getBookById(bookId);

        // Verify the HTTP status and response body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bookDTO, response.getBody());

        // Verify that the service method was called exactly once
        verify(bookService, times(1)).getBookData(bookId);
    }

    @Test
    void testGetBookByIdFailure() {
        int bookId = 1;

        // Simulate a scenario where the book does not exist or some error occurs
        when(bookService.getBookData(bookId)).thenThrow(new RuntimeException("Book not found"));

        // Call the getBookById method on the controller
        ResponseEntity<?> response = bookController.getBookById(bookId);

        // Verify the HTTP status and response body
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertTrue(response.getBody() instanceof Map);

        // Check that the error message matches what the service threw
        Map<String, String> responseBody = (Map<String, String>) response.getBody();
        assertEquals("Book not found", responseBody.get("message"));

        // Verify that the service method was called exactly once
        verify(bookService, times(1)).getBookData(bookId);
    }

    @Test
    void testDeleteBookSuccess(){
        int bookId = 1;
        String title = "Title";
        String author = "Author";

        // Create expected BookDTO instance to simulate returned object
        BookDTO bookDTO = new BookDTO(bookId, title, author, false);

        // Mock deleteBook behavior to return the expected BookDTO
        when(bookService.deleteBook(bookId)).thenReturn(true);

        // Call the deleteBook method on the controller
        ResponseEntity<?> response = bookController.deleteBook(bookId);

        Map<String , String> responseBody = new HashMap<>();
        responseBody.put("message", "Book deleted successfully");

        // Verify the HTTP status and response body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseBody, response.getBody());

        // Verify that the service method was called exactly once
        verify(bookService, times(1)).deleteBook(bookId);
    }

}
