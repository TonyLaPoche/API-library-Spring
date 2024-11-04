package com.rpg.library.entity.book;

import com.rpg.library.entity.author.Author;
import com.rpg.library.entity.kind.Kind;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(nullable = false, unique = true)
    @Size(min = 10, max = 13)
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToMany(mappedBy = "books")
    private List<Kind> kinds = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @PreRemove
    private void removeKinds() {
        this.kinds.forEach(kind -> kind.getBooks().remove(this));
        this.kinds.clear();
    }
}
