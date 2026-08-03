package com.ra.session08.service.impl;

import com.ra.session08.model.dto.request.BorrowCreateDTO;
import com.ra.session08.model.entity.Borrow;
import com.ra.session08.repository.BorrowRepository;
import com.ra.session08.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;
    @Override
    public Borrow createBorrow(BorrowCreateDTO dto) {
        Borrow borrow = Borrow.builder()
                .username(dto.getUsername())
                .bookId(dto.getBookId())
                .build();
        return borrowRepository.save(borrow);
    }
}
