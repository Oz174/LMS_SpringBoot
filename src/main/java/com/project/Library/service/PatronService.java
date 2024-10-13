package com.project.Library.service;

import com.project.Library.dto.PatronDTO;
import com.project.Library.dto.PatronSavedDTO;

import java.util.List;

public interface PatronService {
    String addPatron(PatronSavedDTO PatronSavedDTO);

    List<PatronDTO> getAllPatrons();

    String updatePatron(int id, PatronSavedDTO PatronSavedDTO);

    String deletePatron(int id);

    PatronDTO getPatronData(int id);
}
