package com.rpg.library.services.book;

import com.rpg.library.dto.book.BookDTO;
import com.rpg.library.dto.book.BookFormDTO;
import com.rpg.library.entity.author.Author;
import com.rpg.library.entity.book.Book;
import com.rpg.library.entity.kind.Kind;
import com.rpg.library.exceptions.book.BookNotFoundException;
import com.rpg.library.mappers.book.BookMapper;
import com.rpg.library.repository.author.AuthorRepository;
import com.rpg.library.repository.book.BookRepository;
import com.rpg.library.repository.kind.KindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;
    private final KindRepository kindRepository;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(this.bookMapper::toDTO).toList();
    }
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        return bookMapper.toDTO(book);
    }
    @Transactional
    public BookDTO createBook(BookFormDTO bookFormDTO) {
        Book book = bookMapper.toEntity(bookFormDTO);
        final Author author = authorRepository.findById(bookFormDTO.getAuthorId()).orElseThrow();
        book.setAuthor(author);
        final List<Kind> kinds = kindRepository.findAllById(bookFormDTO.getKindIds());
        book.getKinds().addAll(kinds);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDTO(savedBook);
    }
    @Transactional
    public BookDTO updateBook(Long id, BookFormDTO bookFormDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));

        List<Kind> kinds = kindRepository.findAllById(bookFormDTO.getKindIds());


        book.getKinds().forEach(kind -> kind.getBooks().remove(book));
        book.getKinds().clear();
        book.getKinds().addAll(kinds);

        kinds.forEach(kind -> kind.getBooks().add(book));

        Author author = authorRepository.findById(bookFormDTO.getAuthorId()).orElseThrow();
        author.addBook(book);

        bookMapper.updateBookFromDTO(bookFormDTO, book);
        bookRepository.save(book);
        return bookMapper.toDTO(book);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow();
        bookRepository.delete(book);
    }
}
