package com.library.controller;

import com.library.controller.book.BookNotFoundException;
import com.library.controller.book.BookUnavalibeException;
import com.library.controller.book.IllegalBookStatusException;
import com.library.controller.lending.LendingNotFoundException;
import com.library.controller.title.TitleNotFoundException;
import com.library.controller.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException (BookNotFoundException e) {
        return new ResponseEntity<>("Book with this id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookUnavalibeException.class)
    public ResponseEntity<Object> handleBookUnavalibeException (BookUnavalibeException e) {
        return new ResponseEntity<>("This book is unavalibe at this moment", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalBookStatusException.class)
    public ResponseEntity<Object> handleIllegalBookStatus (IllegalBookStatusException e) {
        return new ResponseEntity<>("Provided book status is incorrect", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TitleNotFoundException.class)
    public ResponseEntity<Object> handleTitleNotFoundException (TitleNotFoundException e) {
        return new ResponseEntity<>("Title with this ID does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException (UserNotFoundException e ) {
        return new ResponseEntity<>("User with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LendingNotFoundException.class)
    public ResponseEntity<Object> handleLendingNotFoundException (LendingNotFoundException e) {
        return new ResponseEntity<>("Lending with given id does not exist", HttpStatus.BAD_REQUEST);
    }

}
