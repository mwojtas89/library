package com.library.controller.title;

import com.library.domain.Title;
import com.library.domain.TitleDto;
import com.library.mapper.TitleMapper;
import com.library.service.TitleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/title")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TitleControler {

    private final TitleDbService titleDbService;
    private final TitleMapper titleMapper;

    @GetMapping
    public ResponseEntity<List<Title>> getAllTitles () {
        return ResponseEntity.ok(titleDbService.findAllTitles());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTitle (@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        titleDbService.saveTitle(title);
        return ResponseEntity.ok().build();
    }
}
