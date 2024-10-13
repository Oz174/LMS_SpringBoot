package com.project.Library.controller;


import com.project.Library.dto.PatronDTO;
import com.project.Library.dto.PatronSavedDTO;
import com.project.Library.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/patrons")
public class PatronController {

    @Autowired
    private PatronService PatronService;

    @PostMapping("/")
    public String savePatron(@RequestBody PatronSavedDTO PatronSavedDTO){
        String Patronname = PatronService.addPatron(PatronSavedDTO);
        return Patronname;
    }

    @GetMapping("/")
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
    public String updatePatron(@PathVariable(value="id") int id,@RequestBody PatronSavedDTO PatronSavedDTO){
        String Patronname = PatronService.updatePatron(id , PatronSavedDTO);
        return Patronname;
    }

    @DeleteMapping("/{id}")
    public String deletePatron(@PathVariable(value = "id") int id){
        String Patronname = PatronService.deletePatron(id);
        return Patronname;
    }

}
