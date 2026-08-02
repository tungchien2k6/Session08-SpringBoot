package com.ra.session08.model.mapper;

import com.ra.session08.model.dto.request.BookRequestDTO;
import com.ra.session08.model.dto.response.BookResponseDTO;
import com.ra.session08.model.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponseDTO bookToBookResponseDTO(Book book);
    List<BookResponseDTO> booksToBookResponseDTOList(List<Book> books);
    @Mapping(target = "coverUrl", ignore = true)
    Book bookDTOToBook(BookRequestDTO bookRequestDTO);
}
