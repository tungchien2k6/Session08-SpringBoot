package com.ra.session08.service.impl;

import com.ra.session08.model.dto.request.BookRequestDTO;
import com.ra.session08.model.dto.response.BookResponseDTO;
import com.ra.session08.model.entity.Book;
import com.ra.session08.model.mapper.BookMapper;
import com.ra.session08.repository.BookRepository;
import com.ra.session08.service.BookService;
import com.ra.session08.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository  bookRepository;
    private final BookMapper  bookMapper;
    private final UploadService uploadService;
    @Override
    public List<BookResponseDTO> getBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.booksToBookResponseDTOList(books);
    }

    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {
        String coverUrl = "";
        if (bookRequestDTO.getCoverUrl() != null) {
            coverUrl = uploadService.uploadToLocal(bookRequestDTO.getCoverUrl());
        }
        Book book = bookMapper.bookDTOToBook(  bookRequestDTO);
        book.setCoverUrl(coverUrl);
        Book bookNew =  bookRepository.save(book);
        return bookMapper.bookToBookResponseDTO(bookNew);
    }
}
