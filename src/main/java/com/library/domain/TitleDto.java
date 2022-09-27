package com.library.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TitleDto {

    private String title;
    private String author;
    private LocalDate publicationDate;

}
