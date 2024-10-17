package com.project.Library.controller;

import com.project.Library.service.BorrowService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BorrowControllerTest {

    @InjectMocks
    private BorrowController borrowController;

    @Mock
    private BorrowService borrowService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBorrowBookSuccess() {
        int bookId = 1;
        int patronId = 1;

        // Mock borrowBook behavior to return true (since it's not void)
        when(borrowService.borrowBook(bookId, patronId)).thenReturn(true);

        ResponseEntity<?> response = borrowController.borrowBook(bookId, patronId);

        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "Book Borrow Successfully");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    void testBorrowBookFailure() {
        int bookId = 1;
        int patronId = 1;

        // Mock borrowBook to throw an exception
        when(borrowService.borrowBook(bookId, patronId)).thenThrow(new RuntimeException("Book is already borrowed"));

        ResponseEntity<?> response = borrowController.borrowBook(bookId, patronId);

        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "Book is already borrowed");

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    void testReturnBookSuccess() {
        int bookId = 1;
        int patronId = 1;

        // Mock returnBook behavior to return true
        when(borrowService.returnBook(bookId, patronId)).thenReturn(true);

        ResponseEntity<?> response = borrowController.returnBook(bookId, patronId);

        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "Book returned Successfully");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    void testReturnBookFailure() {
        int bookId = 1;
        int patronId = 1;

        // Mock returnBook to throw an exception
        when(borrowService.returnBook(bookId, patronId)).thenThrow(new RuntimeException("Book is not borrowed by this patron"));

        ResponseEntity<?> response = borrowController.returnBook(bookId, patronId);

        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "Book is not borrowed by this patron");

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

}
