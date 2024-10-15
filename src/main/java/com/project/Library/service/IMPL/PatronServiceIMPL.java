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
    public PatronDTO addPatron(PatronSavedDTO patronSavedDTO) {


        PatronRepo.findByMembershipNo(patronSavedDTO.getMembership_no())
                .ifPresent(patron -> {
            throw new RuntimeException("Patron with Membership No. " + patronSavedDTO.getMembership_no() + " already exists !!");
        });
        Patron patron = new Patron(
                patronSavedDTO.getName(),
                patronSavedDTO.getPhone_no(),
                patronSavedDTO.getMembership_no()
        );
        PatronRepo.save(patron);
        PatronDTO patronDTO = new PatronDTO(
                patron.getPatron_id(),
                patron.getName(),
                patron.getPhone_no(),
                patron.getMembershipNo()
        );
        return patronDTO;
    }

    @Override
    public List<PatronDTO> getAllPatrons() {
        List<Patron> allPatrons = PatronRepo.findAll();
        List<PatronDTO> PatronDTOList = new ArrayList<>();

        for (Patron patron:allPatrons){
            PatronDTO patronDTO = new PatronDTO(
                    patron.getPatron_id(),
                    patron.getName(),
                    patron.getPhone_no(),
                    patron.getMembershipNo()
            );
            PatronDTOList.add(patronDTO);
        }
        return PatronDTOList;
    }

    @Override
    public PatronDTO updatePatron(int id, PatronSavedDTO patronUpdateDTO) {
        // check if there's a Patron with the id that exists

        if (PatronRepo.existsById(id)){
            Patron patron = PatronRepo.getReferenceById(id);
            patron.setName(patronUpdateDTO.getName());
            patron.setPhone_no(patronUpdateDTO.getPhone_no());
            patron.setMembershipNo(patronUpdateDTO.getMembership_no());
            PatronRepo.save(patron);
            PatronDTO patronDTO = new PatronDTO(
                    patron.getPatron_id(),
                    patron.getName(),
                    patron.getPhone_no(),
                    patron.getMembershipNo()
            );
            return patronDTO;
        }
        else{
            throw new RuntimeException("Patron ID Doesn't Exist !!");
        }

    }

    @Override
    public boolean deletePatron(int id) {
        if (PatronRepo.existsById(id)){
            PatronRepo.deleteById(id);

            return true;
        }
        else{
         throw new RuntimeException("Patron ID Doesn't Exist !!");
        }
    }

    @Override
    public PatronDTO getPatronData(int id) {
       if(PatronRepo.existsById(id)){
           Patron patron = PatronRepo.getReferenceById(id);
           PatronDTO patronDTO = new PatronDTO(
                   patron.getPatron_id(),
                   patron.getName(),
                   patron.getPhone_no(),
                   patron.getMembershipNo()
           );
           return patronDTO;
       }
       else{
           throw new RuntimeException("Patron ID Doesn't Exist !!");
       }
    }
}
