package com.rpg.library.controllers.book;

import com.rpg.library.dto.book.BookDTO;
import com.rpg.library.dto.book.BookFormDTO;
import com.rpg.library.exceptions.book.BookNotFoundException;
import com.rpg.library.services.book.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody @Valid BookFormDTO bookFormDTO) {
        return bookService.createBook(bookFormDTO);
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(
            @PathVariable long id,
            @RequestBody @Valid BookFormDTO bookFormDTO
    ) {
        return bookService.updateBook(id, bookFormDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

    @ExceptionHandler(BookNotFoundException.class)  // Crée une exception personnalisée
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleBookNotFound(BookNotFoundException ex) {
        return ex.getMessage();  // Retourne un message d'erreur
    }

}
