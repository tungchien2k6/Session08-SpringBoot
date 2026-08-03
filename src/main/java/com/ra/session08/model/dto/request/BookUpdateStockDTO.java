package com.ra.session08.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookUpdateStockDTO {
    @NotNull(message = "Stock không được để trống")
    @Min(value = 0, message = "Stock không được nhỏ hơn 0")
    private Integer stock;
}
