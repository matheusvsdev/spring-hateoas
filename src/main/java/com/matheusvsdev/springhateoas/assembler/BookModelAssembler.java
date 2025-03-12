package com.matheusvsdev.springhateoas.assembler;

import com.matheusvsdev.springhateoas.controller.BookController;
import com.matheusvsdev.springhateoas.dto.BookDTO;
import com.matheusvsdev.springhateoas.model.BookEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BookModelAssembler implements RepresentationModelAssembler<BookEntity, EntityModel<BookDTO>> {

    @Override
    public EntityModel<BookDTO> toModel(BookEntity entity) {
        BookDTO dto = new BookDTO(entity);
        return EntityModel.of(
                dto,
                linkTo(methodOn(BookController.class).findById(entity.getId())).withSelfRel(),
                linkTo(methodOn(BookController.class).findAll(null)).withRel("all-books"));
    }
}
