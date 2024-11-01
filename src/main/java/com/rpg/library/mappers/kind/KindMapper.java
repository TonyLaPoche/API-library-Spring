package com.rpg.library.mappers.kind;

import com.rpg.library.dto.kind.KindDTO;
import com.rpg.library.entity.kind.Kind;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface KindMapper {
    KindDTO toDTO(Kind kind);

    @Mapping(ignore = true, target = "id")
    Kind toEntity(KindDTO kindDTO);

    void updateEntity(KindDTO kindDTO,@MappingTarget Kind kind);
}
