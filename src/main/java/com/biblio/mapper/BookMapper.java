package com.biblio.mapper;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import com.biblio.domain.Book;
import com.biblio.dto.BookDto;
import com.biblio.dto.CreateBookRequest;

@Configuration
@Mapper(componentModel = "spring")
public interface BookMapper {

  Book toBook(CreateBookRequest createBookRequest);

  BookDto toBookDto(Book book);

}