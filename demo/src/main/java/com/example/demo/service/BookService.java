package com.example.demo.service;


import com.example.demo.dto.BookResponseDTO;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;
    private final ModelMapper mapper;

    public BookService(BookRepo bookRepo, ModelMapper mapper) {
        this.bookRepo = bookRepo;
        this.mapper = mapper;
    }

    public List<BookResponseDTO> getAllBooks() {
        return bookRepo
                .findAll().stream()
                .map(book -> mapper.map(book, BookResponseDTO.class))
                .toList();
    }

    public BookResponseDTO getBook(int id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException("No Book with that id exists"));
        return mapper.map(book, BookResponseDTO.class);
    }
}
