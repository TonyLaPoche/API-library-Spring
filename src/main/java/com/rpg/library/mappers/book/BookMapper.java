package com.rpg.library.mappers.book;

import com.rpg.library.dto.book.BookDTO;
import com.rpg.library.dto.book.BookFormDTO;
import com.rpg.library.entity.book.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDTO(Book book);

    @Mapping(ignore = true, target = "id")
    Book toEntity(BookFormDTO bookFormDTO);

    void updateEntity(BookDTO bookDTO, @MappingTarget Book book);

    void updateBookFromDTO(BookFormDTO bookFormDTO, @MappingTarget Book book);
}
