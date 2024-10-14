package com.project.Library.controller;


import com.project.Library.dto.PatronDTO;
import com.project.Library.dto.PatronSavedDTO;
import com.project.Library.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/patrons")
public class PatronController {

    @Autowired
    private PatronService PatronService;

    @PostMapping
    public ResponseEntity<?> savePatron(@RequestBody PatronSavedDTO patronSavedDTO) {
        try {
            PatronDTO patron = PatronService.addPatron(patronSavedDTO);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Patron saved successfully");
            return ResponseEntity.status(HttpStatus.OK).body(patron);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    @GetMapping
    public ResponseEntity<?> getAllPatrons() {
        try {
            List<PatronDTO> allPatrons = PatronService.getAllPatrons();
            return ResponseEntity.status(HttpStatus.OK).body(allPatrons);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPatronById(@PathVariable(value = "id") int id) {
        try {
            PatronDTO Patronname = PatronService.getPatronData(id);
            return ResponseEntity.status(HttpStatus.OK).body(Patronname);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatron(@PathVariable(value = "id") int id, @RequestBody PatronSavedDTO patronSavedDTO) {
        try {
            PatronDTO patron = PatronService.updatePatron(id, patronSavedDTO);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Patron updated successfully");
            return ResponseEntity.status(HttpStatus.OK).body(patron);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatron(@PathVariable(value = "id") int id) {
        try {
            PatronService.deletePatron(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Patron deleted successfully");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
