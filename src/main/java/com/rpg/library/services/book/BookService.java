package com.rpg.library.services.book;

import com.rpg.library.dto.book.BookDTO;
import com.rpg.library.dto.book.BookFormDTO;
import com.rpg.library.entity.book.Book;
import com.rpg.library.exceptions.book.BookNotFoundException;
import com.rpg.library.mappers.book.BookMapper;
import com.rpg.library.repository.book.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        return bookMapper.toDTO(book);
    }
    @Transactional
    public BookDTO createBook(BookFormDTO bookFormDTO) {
        Book book = bookMapper.toEntity(bookFormDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDTO(savedBook);
    }
    @Transactional
    public BookDTO updateBook(Long id, BookFormDTO bookFormDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        bookMapper.updateBookFromDTO(bookFormDTO, book);
        Book updatedBook = bookRepository.save(book);
        return bookMapper.toDTO(updatedBook);
    }
    @Transactional
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        bookRepository.delete(book);
    }
}
