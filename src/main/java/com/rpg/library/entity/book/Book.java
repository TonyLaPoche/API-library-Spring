package com.rpg.library.entity.book;

import com.rpg.library.entity.author.Author;
import com.rpg.library.entity.kind.Kind;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 1, max = 50)
    private String title;

    @Column(nullable = false)
    @Size(min = 1, max = 2000)
    private String description;

    @Size(min = 1, max = 500)
    @Pattern(regexp = "^(https://.*|/?.+\\.(png|jpg|jpeg|gif|bmp/webp))$",
            message = "L'image doit être un lien HTTPS valide ou un chemin d'image local avec une extension valide.")
    private String image;

    @Column(nullable = false, unique = true, updatable = false)
    @Size(min = 10, max = 13)
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    private Author author;

    @ManyToMany(mappedBy = "books")
    @Valid
    @Builder.Default
    private List<Kind> kinds = new ArrayList<>();

}
