package com.library.service;

import com.library.controller.title.TitleNotFoundException;
import com.library.domain.Title;
import com.library.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TitleDbService {

    private final TitleRepository titleRepository;

    public Title saveTitle (Title title) {
        return titleRepository.save(title);
    }

    public List<Title> findAllTitles () {
        return titleRepository.findAll();
    }

    public Title findTitleById (long titleId) throws TitleNotFoundException  {
        return titleRepository.findById(titleId).orElseThrow(TitleNotFoundException::new);
    }

}
