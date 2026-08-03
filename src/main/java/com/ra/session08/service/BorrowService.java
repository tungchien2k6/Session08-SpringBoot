package com.ra.session08.service;

import com.ra.session08.model.dto.request.BorrowCreateDTO;
import com.ra.session08.model.entity.Borrow;

public interface BorrowService {
    Borrow createBorrow(BorrowCreateDTO dto);
}
