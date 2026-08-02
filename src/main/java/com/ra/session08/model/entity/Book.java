package com.ra.session08.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", length = 150, nullable = false, unique = true)
    private String title;
    @Column(name = "author", length = 150, nullable = false)
    private String author;
    @Column(name = "stock", nullable = false)
    private Integer stock;
    @Column(name = "coverUrl", length = 255)
    private String coverUrl;
}
