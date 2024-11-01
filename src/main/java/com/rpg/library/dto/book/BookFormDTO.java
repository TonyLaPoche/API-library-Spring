package com.rpg.library.dto.book;

import com.rpg.library.dto.author.AuthorDTO;
import com.rpg.library.dto.kind.KindDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookFormDTO {
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Pattern(regexp = "^(https://.*|/?.+\\.(png|jpg|jpeg|gif|bmp|webp))$",
            message = "L'image doit être un lien HTTPS valide ou un chemin d'image local avec une extension valide.")
    private String image;

    @NotNull
    @Valid
    private AuthorDTO author;

    @NotEmpty
    @Valid
    private List<KindDTO> kinds;
}
