package com.library.controller.book;

import com.library.controller.title.TitleNotFoundException;
import com.library.domain.Book;
import com.library.domain.BookDto;
import com.library.domain.BookStatus;
import com.library.mapper.BookMapper;
import com.library.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BookController {

    private final BookDbService bookDbService;
    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks () {
        return ResponseEntity.ok(bookDbService.findAllBooks());
    }

    @GetMapping(value = "{titleId}")
    public ResponseEntity<Long> avalibleBooksByTitleId (@PathVariable Long titleId) {
        return ResponseEntity.ok(bookDbService.countBooksByStatusAndTitleId(BookStatus.AVAILABLE, titleId));
    }

    @PostMapping(value = "{titleId}")
    public ResponseEntity<Void> addNewBook (@PathVariable Long titleId) throws TitleNotFoundException {
        bookDbService.addNewBook(titleId);

        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBookStatus (@RequestBody BookDto bookDto) throws BookNotFoundException, IllegalBookStatusException{
        Book book = bookMapper.mapToBook(bookDto);

        bookDbService.saveBook(book);
        return ResponseEntity.ok().build();
    }


}
