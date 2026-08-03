package com.ra.session08.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "borrows")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "book_id", length = 150, nullable = false, unique = true)
    private Integer bookId;
    @Column(name = "username", length = 150, nullable = false)
    private String username;
}
