package com.example.demo.dto;

import lombok.Data;

@Data
public class BookResponseDTO {
    private int book_id;
    private String name;
    private String publisher;
    private String author;
}
