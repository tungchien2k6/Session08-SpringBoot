package com.ra.session08.model.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
