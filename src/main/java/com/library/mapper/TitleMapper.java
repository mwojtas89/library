package com.library.mapper;

import com.library.domain.Title;
import com.library.domain.TitleDto;
import org.springframework.stereotype.Service;

@Service
public class TitleMapper {
    public Title mapToTitle (TitleDto titleDto) {
        return new Title(0L, titleDto.getTitle(), titleDto.getAuthor(), titleDto.getPublicationDate());
    }
}
