package com.example.Chapter4.service;

import com.example.Chapter4.model.User;
import com.example.Chapter4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }
    public User create(User user){
        return userRepository.save(user);
    }
}
