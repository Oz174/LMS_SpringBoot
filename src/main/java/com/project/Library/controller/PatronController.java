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
    public PatronDTO savePatron(@RequestBody PatronSavedDTO patronSavedDTO){
        PatronDTO Patronname = PatronService.addPatron(patronSavedDTO);
        return Patronname;
    }

    @GetMapping
    public List<PatronDTO> getAllPatrons(){
        List<PatronDTO> all_Patrons = PatronService.getAllPatrons();
        return all_Patrons;
    }

    @GetMapping("/{id}")
    public PatronDTO getPatronData(@PathVariable(value="id") int id){
        PatronDTO PatronDTO = PatronService.getPatronData(id);
        return PatronDTO;
    }

    @PutMapping("/{id}")
    public PatronDTO updatePatron(@PathVariable(value="id") int id,@RequestBody PatronSavedDTO patronSavedDTO){
        PatronDTO Patronname = PatronService.updatePatron(id , patronSavedDTO);
        return Patronname;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatron(@PathVariable(value = "id") int id){
        PatronService.deletePatron(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Patron Deleted Successfully");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
