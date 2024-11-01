package com.rpg.library.dto.author;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorFormDTO {
    @NotBlank
    private String name;

    @Pattern(regexp = "^(https://.*|/?.+\\.(png|jpg|jpeg|gif|bmp|webp))$",
            message = "L'image doit être un lien HTTPS valide ou un chemin d'image local avec une extension valide.")
    private String image;
}