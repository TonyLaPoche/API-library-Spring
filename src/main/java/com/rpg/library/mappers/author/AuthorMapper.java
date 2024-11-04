package com.rpg.library.mappers.author;

import com.rpg.library.dto.author.AuthorDTO;
import com.rpg.library.dto.author.AuthorFormDTO;
import com.rpg.library.entity.author.Author;
import com.rpg.library.mappers.book.BookMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface AuthorMapper {

    AuthorDTO toDTO(Author author);

    @Mapping(ignore = true, target = "id")
    Author toEntity(AuthorFormDTO authorFormDTO);

    @Mapping(ignore = true, target = "id")
    void updateEntity(AuthorFormDTO authorFormDTO, @MappingTarget Author author);
}
