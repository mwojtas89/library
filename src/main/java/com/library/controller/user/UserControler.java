package com.library.controller.user;

import com.library.domain.User;
import com.library.domain.UserDto;
import com.library.mapper.UserMapper;
import com.library.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserControler {

    private final UserDbService userDbService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers () {
        return ResponseEntity.ok(userDbService.getAllUsers());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser (@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userDbService.saveUser(user);
        return ResponseEntity.ok().build();
    }
}
