package com.ra.session08.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookRequestDTO {
    @NotBlank
    private String title;
    @NotBlank(message = "Tác giả không được để trống")
    private String author;
    @NonNull
    private Integer stock;
    private MultipartFile coverUrl;
}
