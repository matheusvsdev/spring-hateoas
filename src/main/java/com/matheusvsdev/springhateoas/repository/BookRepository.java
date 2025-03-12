package com.matheusvsdev.springhateoas.repository;

import com.matheusvsdev.springhateoas.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
