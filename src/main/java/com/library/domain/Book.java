package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "title")
    private Title title;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookStatus bookStatus;
}
