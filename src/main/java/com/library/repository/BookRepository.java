package com.library.repository;

import com.library.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll ();

    @Query(value = "SELECT count(*) FROM books where bookStatus = :status and books.title.id = :titleId",
            nativeQuery = true)
    long countBooksByStatusAndTitleId (@Param("status") String status, @Param("titleId") long titleId);
}
