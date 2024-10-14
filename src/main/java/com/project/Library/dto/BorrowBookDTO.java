package com.project.Library.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BorrowBookDTO {
    private LocalDate borrow_date;
    private LocalDate return_date; // for if user exceeds return date , we scale for adding a fine feature
}
