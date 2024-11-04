package com.rpg.library.services.author;

import com.rpg.library.dto.author.AuthorDTO;
import com.rpg.library.dto.author.AuthorFormDTO;
import com.rpg.library.entity.author.Author;
import com.rpg.library.mappers.author.AuthorMapper;
import com.rpg.library.repository.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(authorMapper::toDTO).toList();
    }

    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return authorMapper.toDTO(author);
    }

    public AuthorDTO createAuthor(AuthorFormDTO authorFormDTO) {
        Author author = authorMapper.toEntity(authorFormDTO);
        author = authorRepository.save(author);
        return authorMapper.toDTO(author);
    }

    public AuthorDTO updateAuthor(Long id, AuthorFormDTO authorFormDTO) {
        Author author = authorRepository.findById(id).orElseThrow();
        authorMapper.updateEntity(authorFormDTO, author);
        author = authorRepository.save(author);
        return authorMapper.toDTO(author);
    }

    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        authorRepository.delete(author);
    }
}
