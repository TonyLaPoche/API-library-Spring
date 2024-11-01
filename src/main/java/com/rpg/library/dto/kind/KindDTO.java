package com.rpg.library.dto.kind;

import com.rpg.library.dto.book.BookDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KindDTO {
    private Long id;

    @NotBlank
    private String name;

    @Valid
    private List<BookDTO> books;
}
