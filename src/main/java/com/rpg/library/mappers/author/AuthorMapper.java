package com.rpg.library.mappers.author;

import com.rpg.library.dto.author.AuthorDTO;
import com.rpg.library.entity.author.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDTO toDTO(Author author);

    @Mapping(ignore = true, target = "id")
    Author toEntity(AuthorDTO authorDTO);

    void updateEntity(AuthorDTO authorDTO, @MappingTarget Author author);
}
