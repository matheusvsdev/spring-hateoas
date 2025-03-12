package com.matheusvsdev.springhateoas.service;

import com.matheusvsdev.springhateoas.dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Page<BookDTO> findBooks(Pageable pageable);
    BookDTO findBookById(Long id);
}
