package com.rpg.library.dto.kind;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KindFormDTO {
    private Long id;  // Optionnel pour la création, mais nécessaire pour la mise à jour

    @NotBlank
    private String name;  // Validation pour s'assurer que le nom est présent
}
