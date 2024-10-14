package com.project.Library.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookSavedDTO {
    // private int book_id ;    --no need for this here !
    private String title;
    private String author_name;
}
