package com.project.Library.service;

import com.project.Library.dto.PatronDTO;
import com.project.Library.dto.PatronSavedDTO;

import java.util.List;

public interface PatronService {
    PatronDTO addPatron(PatronSavedDTO patronSavedDTO);

    List<PatronDTO> getAllPatrons();

    PatronDTO updatePatron(int id, PatronSavedDTO patronUpdateDTO);

    boolean deletePatron(int id);

    PatronDTO getPatronData(int id);
}
