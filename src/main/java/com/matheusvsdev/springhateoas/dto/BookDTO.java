package com.matheusvsdev.springhateoas.dto;

import com.matheusvsdev.springhateoas.model.BookEntity;

import java.time.LocalDate;

public class BookDTO {

    private Long id;
    private String title;
    private Integer numberOfPages;
    private LocalDate publicationDate;

    public BookDTO() {
    }

    public BookDTO(Long id, String title, Integer numberOfPages, LocalDate publicationDate) {
        this.id = id;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.publicationDate = publicationDate;
    }

    public BookDTO(BookEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.numberOfPages = entity.getNumberOfPages();
        this.publicationDate = entity.getPublicationDate();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}
