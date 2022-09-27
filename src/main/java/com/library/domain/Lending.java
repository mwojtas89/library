package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name ="lendings")
public class Lending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name = "lent_book", referencedColumnName = "book_id")
    private Book lentBook;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User client;

    @Column(name = "lent_date")
    private LocalDate lentDate;

    @Column(name = "return_date")
    private LocalDate returnDate;
}
