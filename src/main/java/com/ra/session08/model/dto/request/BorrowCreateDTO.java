package com.ra.session08.model.dto.request;

import com.ra.session08.validation.ExistingBookId;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BorrowCreateDTO {
    @ExistingBookId
    private Integer bookId;
    @NotBlank(message = "Username không được để trống")
    private String username;
}
