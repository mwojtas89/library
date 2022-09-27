package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name= "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_of_join")
    private LocalDate localDate;
}
