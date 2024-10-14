package com.project.Library.controller;


import com.project.Library.dto.BorrowBookDTO;
import com.project.Library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/books")
public class BorrowController {

    @Autowired
    private BookService bookService;
}