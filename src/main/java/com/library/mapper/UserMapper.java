package com.library.mapper;

import com.library.domain.Book;
import com.library.domain.BookDto;
import com.library.domain.User;
import com.library.domain.UserDto;
import com.library.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserMapper {

    public User mapToUser (UserDto userDto) {
        return new User(0L, userDto.getFirstName(), userDto.getName(), LocalDate.now());
    }
}
