package com.library.controller.lending;

import com.library.controller.book.BookNotFoundException;
import com.library.controller.book.BookUnavalibeException;
import com.library.controller.title.TitleNotFoundException;
import com.library.controller.user.UserNotFoundException;
import com.library.domain.Lending;
import com.library.service.LendingDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lending")
@CrossOrigin("*")
@RequiredArgsConstructor
public class LendingControler {

    private final LendingDbService lendingDbService;

    @GetMapping
    public ResponseEntity<List<Lending>> getAllLendings () {
        return ResponseEntity.ok(lendingDbService.findAllLendings());
    }

    @PostMapping
    public ResponseEntity<Void> lendBook (@RequestParam(name = "userId") long userId,
                                          @RequestParam(name = "titleId") long titleId) throws UserNotFoundException,
            BookNotFoundException, BookUnavalibeException {
        lendingDbService.lendBook(userId, titleId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{lendingId}")
    public ResponseEntity<Void> returnBook (@PathVariable long lendingId) throws LendingNotFoundException {
        lendingDbService.returnBook(lendingId);
        return ResponseEntity.ok().build();
    }

}
