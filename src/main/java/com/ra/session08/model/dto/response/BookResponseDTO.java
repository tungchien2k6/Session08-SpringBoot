package com.ra.session08.model.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;
    private Integer stock;
    private String coverUrl;
}
