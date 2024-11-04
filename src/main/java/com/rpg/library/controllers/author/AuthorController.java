package com.rpg.library.controllers.author;

import com.rpg.library.dto.author.AuthorDTO;
import com.rpg.library.dto.author.AuthorFormDTO;
import com.rpg.library.services.author.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public AuthorDTO createAuthor(@RequestBody @Valid AuthorFormDTO authorFormDTO) {
        return authorService.createAuthor(authorFormDTO);
    }

    @PutMapping("/{id}")
    public AuthorDTO updateAuthor(@PathVariable Long id, @RequestBody @Valid AuthorFormDTO authorFormDTO) {
        return authorService.updateAuthor(id, authorFormDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }


}
