package com.biblio.service;

import org.springframework.stereotype.Service;

import com.biblio.domain.Book;
import com.biblio.exceptions.BookNotFoundException;
import com.biblio.repository.BookRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAllByOrderByTitle();
    }

    @Override
    public List<Book> getBooksContainingText(String text) {
        return bookRepository.findByIsbnContainingOrTitleContainingOrderByTitle(text, text);
    }

    @Override
    public Book validateAndGetBook(String isbn) {
        return bookRepository.findById(isbn)
                .orElseThrow(() -> new BookNotFoundException(String.format("Book with isbn %s not found", isbn)));
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }
}
