package com.rpg.library.mappers.book;

import com.rpg.library.dto.book.BookDTO;
import com.rpg.library.dto.book.BookFormDTO;
import com.rpg.library.entity.book.Book;
import com.rpg.library.entity.kind.Kind;
import com.rpg.library.mappers.kind.KindMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {KindMapper.class})
public interface BookMapper {

    @Mapping(target = "authorId", source = "author.id")
    @Mapping(target = "kindIds", source = "kinds", qualifiedByName = "mapKindsToIds")
    BookDTO toDTO(Book book);

    @Mapping(ignore = true, target = "id")
    Book toEntity(BookFormDTO bookFormDTO);

    void updateBookFromDTO(BookFormDTO bookFormDTO, @MappingTarget Book book);

    @Named("mapKindsToIds")
    default List<Long> mapKindsToIds(List<Kind> kinds) {
        return kinds.stream().map(Kind::getId).toList();
    }

}

