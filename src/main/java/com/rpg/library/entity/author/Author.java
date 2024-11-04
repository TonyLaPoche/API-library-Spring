package com.rpg.library.entity.author;

import com.rpg.library.entity.book.Book;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 100)
    private String name;

    @Size(min = 1, max = 500)
    @Pattern(regexp = "^(https://.*|/?.+\\.(png|jpg|jpeg|gif|bmp/webp))$",
            message = "L'image doit être un lien HTTPS valide ou un chemin d'image local avec une extension valide.")
    private String image;

    @OneToMany(mappedBy = "author", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @Valid
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        book.setAuthor(this);
        this.books.add(book);
    }
}
