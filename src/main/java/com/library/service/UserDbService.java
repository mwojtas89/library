package com.library.service;

import com.library.controller.user.UserNotFoundException;
import com.library.domain.User;
import com.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDbService {

    private final UserRepository userRepository;

    public User saveUser (User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public User getUserById (long userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }
}
