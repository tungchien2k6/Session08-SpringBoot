package com.ra.session08.controller;

import com.ra.session08.model.dto.request.BorrowCreateDTO;
import com.ra.session08.model.entity.Borrow;
import com.ra.session08.service.BorrowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/borrows")
public class BorrowController {
    private final BorrowService borrowService;

    @PostMapping
    public ResponseEntity<?> createBorrow(@Valid @RequestBody BorrowCreateDTO dto) {
        Borrow borrow = borrowService.createBorrow(dto);
        return new ResponseEntity<>(borrow, HttpStatus.CREATED);
    }
}
