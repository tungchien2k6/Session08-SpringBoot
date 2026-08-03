package com.ra.session08.validation;

import com.ra.session08.repository.BookRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookIdValidator implements ConstraintValidator<ExistingBookId, Integer> {
    private final BookRepository bookRepository;
    @Override
    public boolean isValid(Integer bookId, ConstraintValidatorContext context) {
        if (bookId == null) {
            return true;
        }
        return bookRepository.existsById(Long.valueOf(bookId));
    }
}
