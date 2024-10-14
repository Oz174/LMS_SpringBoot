package com.project.Library.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatronSavedDTO {
    // private int patron_id ;    --no need for this here !
    private String name;
    private String phone_no;
    private int membership_no;
}
