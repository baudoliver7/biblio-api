package com.biblio.service;

import java.util.List;

import com.biblio.domain.Book;

public interface BookService {

    List<Book> getBooks();

    List<Book> getBooksContainingText(String text);

    Book validateAndGetBook(String isbn);

    Book saveBook(Book book);

    void deleteBook(Book book);

}
