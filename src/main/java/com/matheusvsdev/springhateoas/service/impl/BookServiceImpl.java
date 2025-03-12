package com.matheusvsdev.springhateoas.service.impl;

import com.matheusvsdev.springhateoas.dto.BookDTO;
import com.matheusvsdev.springhateoas.model.BookEntity;
import com.matheusvsdev.springhateoas.repository.BookRepository;
import com.matheusvsdev.springhateoas.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<BookDTO> findBooks(Pageable pageable) {
        Page<BookEntity> books = bookRepository.findAll(pageable);
        return books.map(BookDTO::new);
    }

    @Override
    public BookDTO findBookById(Long id) {
        BookEntity book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found :("));
        return new BookDTO(book);
    }
}
