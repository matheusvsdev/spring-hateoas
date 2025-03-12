package com.matheusvsdev.springhateoas.service.impl;

import com.matheusvsdev.springhateoas.assembler.BookModelAssembler;
import com.matheusvsdev.springhateoas.dto.BookDTO;
import com.matheusvsdev.springhateoas.model.BookEntity;
import com.matheusvsdev.springhateoas.repository.BookRepository;
import com.matheusvsdev.springhateoas.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookModelAssembler assembler;

    public BookServiceImpl(BookRepository bookRepository, BookModelAssembler assembler) {
        this.bookRepository = bookRepository;
        this.assembler = assembler;
    }

    @Override
    @Transactional(readOnly = true)
    public PagedModel<EntityModel<BookDTO>> findBooks(Pageable pageable) {
        Page<BookEntity> books = bookRepository.findAll(pageable);
        List<EntityModel<BookDTO>> bookModels = books
                .stream()
                .map(assembler::toModel)
                .toList();

        // Adicionar metadados e links globais ao PagedModel
        PagedModel.PageMetadata metadata = new PagedModel.PageMetadata(
                books.getSize(),          // Tamanho da página
                books.getNumber(),        // Página atual
                books.getTotalElements(), // Total de elementos
                books.getTotalPages()     // Total de páginas
        );

        // Criando os links globais
        return PagedModel.of(
                bookModels,
                metadata
        );
    }

    @Override
    @Transactional(readOnly = true)
    public EntityModel<BookDTO> findBookById(Long id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found :("));
        return assembler.toModel(book);
    }
}
