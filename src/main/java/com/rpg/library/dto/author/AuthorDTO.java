package com.rpg.library.dto.author;

import com.rpg.library.dto.book.BookDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private Long id;

    @NotNull
    private String name;

    @Pattern(regexp = "^(https://.*|/?.+\\.(png|jpg|jpeg|gif|bmp|webp))$",
            message = "L'image doit être un lien HTTPS valide ou un chemin d'image local avec une extension valide.")
    private String image;

    @Valid
    private List<BookDTO> books;
}
