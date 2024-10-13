package com.project.Library.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatronDTO {
        private int patron_id ;
        private String name;
        private String phone_no;
        private int membership_no;
    }
