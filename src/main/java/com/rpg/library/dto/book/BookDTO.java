package com.rpg.library.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Pattern(regexp = "^(https://.*|/?.+\\.(png|jpg|jpeg|gif|bmp|webp))$",
            message = "L'image doit être un lien HTTPS valide ou un chemin d'image local avec une extension valide.")
    private String image;

    @NotBlank
    @NotNull
    private String isbn;

    private Long authorId;

    private List<Long> kindIds = new ArrayList<>();
}
