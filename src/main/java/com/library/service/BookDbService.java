package com.library.service;

import com.library.controller.book.BookNotFoundException;
import com.library.controller.title.TitleNotFoundException;
import com.library.domain.Book;
import com.library.domain.BookStatus;
import com.library.domain.Title;
import com.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookDbService {

    private final BookRepository bookRepository;
    private final TitleDbService titleDbService;

    public List<Book> findAllBooks () {
        return bookRepository.findAll();
    }

    public Book saveBook (Book book) {
        return bookRepository.save(book);
    }

    public Book bookById (long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public long countBooksByStatusAndTitleId (BookStatus bookStatus, long titleId) {
        return bookRepository.countBooksByStatusAndTitleId(bookStatus.toString(), titleId);
    }

    public Book addNewBook (long titleId) throws TitleNotFoundException {
        Title title = titleDbService.findTitleById(titleId);
        Book book = new Book(0L, title, BookStatus.AVAILABLE);
        return bookRepository.save(book);
    }

}
