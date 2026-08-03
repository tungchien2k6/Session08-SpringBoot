package com.ra.session08.controller;

import com.ra.session08.model.dto.request.BookRequestDTO;
import com.ra.session08.model.dto.response.BookResponseDTO;
import com.ra.session08.model.dto.response.ResponseWrapper;
import com.ra.session08.model.dto.request.BookUpdateStockDTO;
import com.ra.session08.service.BookService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        List<BookResponseDTO> bookResponseDTOList = bookService.getBooks();
        return new ResponseEntity<>(bookResponseDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        BookResponseDTO book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createBook(@Valid @ModelAttribute BookRequestDTO bookRequestDTO) {
        BookResponseDTO book = bookService.createBook(bookRequestDTO);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id,@Valid  @RequestBody BookUpdateStockDTO bookUpdateStockDTO) {
        BookResponseDTO book = bookService.updateBook(id, bookUpdateStockDTO);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
