package com.matheusvsdev.springhateoas.service;

import com.matheusvsdev.springhateoas.dto.BookDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

public interface BookService {

    PagedModel<EntityModel<BookDTO>> findBooks(Pageable pageable);
    EntityModel<BookDTO> findBookById(Long id);
}
