package com.library.mapper;

import com.library.controller.book.BookNotFoundException;
import com.library.controller.book.IllegalBookStatusException;
import com.library.domain.Book;
import com.library.domain.BookDto;
import com.library.domain.BookStatus;
import com.library.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookMapper {

    private final BookDbService bookDbService;

    public Book mapToBook (BookDto bookDto) throws BookNotFoundException, IllegalBookStatusException {
        Book book = bookDbService.bookById(bookDto.getId());

        try {
            BookStatus status = BookStatus.valueOf(bookDto.getStatus());
            book.setBookStatus(status);
            return book;
        } catch (Exception e) {
            throw new IllegalBookStatusException();
        }
    }
}
