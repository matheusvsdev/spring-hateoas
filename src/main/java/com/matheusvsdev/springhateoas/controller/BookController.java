package com.matheusvsdev.springhateoas.controller;

import com.matheusvsdev.springhateoas.dto.BookDTO;
import com.matheusvsdev.springhateoas.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public PagedModel<EntityModel<BookDTO>> findAll(Pageable pageable) {
        return bookService.findBooks(pageable);
    }

    @GetMapping(value = "/{id}")
    public EntityModel<BookDTO> findById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }
}
