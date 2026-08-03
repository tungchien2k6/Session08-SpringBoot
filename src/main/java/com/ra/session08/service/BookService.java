package com.ra.session08.service;

import com.ra.session08.model.dto.request.BookRequestDTO;
import com.ra.session08.model.dto.request.BookUpdateStockDTO;
import com.ra.session08.model.dto.response.BookResponseDTO;

import java.util.List;

public interface BookService {
    List<BookResponseDTO> getBooks();
    BookResponseDTO createBook(BookRequestDTO bookRequestDTO);
    BookResponseDTO updateBook(Long id, BookUpdateStockDTO bookUpdateStockDTO);
}
