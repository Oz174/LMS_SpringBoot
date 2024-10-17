package com.project.Library.controller;
import com.project.Library.service.PatronService;
import com.project.Library.dto.PatronSavedDTO;
import com.project.Library.dto.PatronDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PatronControllerTest {

    @InjectMocks
    private PatronController patronController;

    @Mock
    private PatronService patronService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePatronSuccess(){
        String name = "Name";
        String phoneNumber = "1234567890";
        int membershipno = 1234;

        PatronSavedDTO patronSavedDTO = new PatronSavedDTO(name, phoneNumber, membershipno);
        PatronDTO patronDTO = new PatronDTO(1, name, phoneNumber, membershipno);
        when(patronService.addPatron(patronSavedDTO)).thenReturn(patronDTO);

        ResponseEntity<?> response = patronController.addPatron(patronSavedDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(patronDTO, response.getBody());

        verify(patronService, times(1)).addPatron(patronSavedDTO);

    }

    @Test
    void testCreatePatronFailure(){
        String name = "Name";
        String phoneNumber = "1234567890";
        int membershipno = 1234;

        PatronSavedDTO patronSavedDTO = new PatronSavedDTO(name, phoneNumber, membershipno);
        when(patronService.addPatron(patronSavedDTO)).thenThrow(new RuntimeException("Patron with Membership No. " + membershipno + " already exists !!"));

        ResponseEntity<?> response = patronController.addPatron(patronSavedDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Map<String, String> responseBody = (Map<String, String>) response.getBody();
        assertEquals("Patron with Membership No. 1234 already exists !!", responseBody.get("message"));

        verify(patronService, times(1)).addPatron(patronSavedDTO);
    }

    @Test
    void testGetPatreonSuccess(){
        PatronDTO patronDTO = new PatronDTO(1, "Name", "1234567890", 1234);
        when(patronService.getAllPatrons()).thenReturn(List.of(patronDTO));

        ResponseEntity<?> response = patronController.getAllPatrons();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(patronDTO), response.getBody());

        verify(patronService, times(1)).getAllPatrons();
    }

    @Test
    void testDeletePatronFailure(){
        int id = 1;
        when(patronService.deletePatron(id)).thenThrow(new RuntimeException("Patron ID Doesn't Exist !!"));

        ResponseEntity<?> response = patronController.deletePatron(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Map<String, String> responseBody = (Map<String, String>) response.getBody();
        assertEquals("Patron ID Doesn't Exist !!", responseBody.get("message"));

        verify(patronService, times(1)).deletePatron(id);
    }
}
