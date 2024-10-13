package com.project.Library.service.IMPL;

import com.project.Library.dto.PatronDTO;
import com.project.Library.dto.PatronSavedDTO;
import com.project.Library.entity.Patron;
import com.project.Library.repo.PatronRepo;
import com.project.Library.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatronServiceIMPL implements PatronService {

    @Autowired
    private PatronRepo PatronRepo;

    @Override
    public String addPatron(PatronSavedDTO PatronSavedDTO) {
        Patron Patron = new Patron(
                PatronSavedDTO.getName(),
                PatronSavedDTO.getPhone_no(),
                PatronSavedDTO.getMembership_no()
        );
        PatronRepo.save(Patron);
        return "Patron Added Successfully";
    }

    @Override
    public List<PatronDTO> getAllPatrons() {
        List<Patron> allPatrons = PatronRepo.findAll();
        List<PatronDTO> PatronDTOList = new ArrayList<>();

        for (Patron patron:allPatrons){
            PatronDTO PatronDTO = new PatronDTO(
                    patron.getPatron_id(),
                    patron.getName(),
                    patron.getPhone_no(),
                    patron.getMembership_no()
            );
            PatronDTOList.add(PatronDTO);
        }
        return PatronDTOList;
    }

    @Override
    public String updatePatron(int id, PatronSavedDTO PatronUpdateDTO) {
        // check if there's a Patron with the id that exists

        if (PatronRepo.existsById(id)){
            Patron Patron = PatronRepo.getReferenceById(id);
            Patron.setName(PatronUpdateDTO.getName());
            Patron.setPhone_no(PatronUpdateDTO.getPhone_no());
            Patron.setMembership_no(PatronUpdateDTO.getMembership_no());
            PatronRepo.save(Patron);
            return "Update Successful!";

        }
        else{
            System.out.println("Patron ID Doesn't Exist !!");
            return "Entry doesn't exist!";
        }

    }

    @Override
    public String deletePatron(int id) {
        if (PatronRepo.existsById(id)){
            PatronRepo.deleteById(id);
            return "Deleted Successfully";
        }
        else{
            return "Patron Doesn't Exist" ;
        }
    }

    @Override
    public PatronDTO getPatronData(int id) {
        Patron Patron = PatronRepo.getReferenceById(id);
        PatronDTO PatronDTO = new PatronDTO(
                Patron.getPatron_id(),
                Patron.getName(),
                Patron.getPhone_no(),
                Patron.getMembership_no()
        );
        return PatronDTO;
    }
}
