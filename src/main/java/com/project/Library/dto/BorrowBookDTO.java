package com.project.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BorrowBookDTO {
    private LocalDate borrow_date;
    private LocalDate return_date; // for if user exceeds return date , we scale for adding a fine feature
}
