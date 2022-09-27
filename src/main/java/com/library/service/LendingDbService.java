package com.library.service;

import com.library.controller.book.BookNotFoundException;
import com.library.controller.book.BookUnavalibeException;
import com.library.controller.lending.LendingNotFoundException;
import com.library.controller.user.UserNotFoundException;
import com.library.domain.Book;
import com.library.domain.BookStatus;
import com.library.domain.Lending;
import com.library.domain.User;
import com.library.repository.LendingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LendingDbService {

    private final LendingRepository lendingRepository;
    private final BookDbService bookDbService;
    private final UserDbService userDbService;

    public List<Lending> findAllLendings () {
        return lendingRepository.findAll();
    }

    public Lending lendBook (long userId, long bookId) throws BookNotFoundException, UserNotFoundException, BookUnavalibeException {
        User user = userDbService.getUserById(userId);
        Book book = bookDbService.bookById(bookId);

        if(!book.getBookStatus().equals(BookStatus.AVAILABLE)){
            throw new BookUnavalibeException();
        }

        Lending lending = new Lending(0L, book, user, LocalDate.now(), LocalDate.now().plusDays(7));
        book.setBookStatus(BookStatus.LENT);

        bookDbService.saveBook(book);
        return lendingRepository.save(lending);
    }

    public void returnBook (long lendingId) throws LendingNotFoundException {
        Lending lending = lendingRepository.findById(lendingId).orElseThrow(LendingNotFoundException::new);

        Book book = lending.getLentBook();

        book.setBookStatus(BookStatus.AVAILABLE);
        bookDbService.saveBook(book);

        lendingRepository.delete(lending);
    }


}
