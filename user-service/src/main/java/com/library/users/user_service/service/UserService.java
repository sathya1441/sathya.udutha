package com.library.users.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.users.user_service.entity.User;
import com.library.users.user_service.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User fetchUserByUserName(String userName) {
        return userRepository.findByUserName(userName).get();
    }

    public String addUser(User user) {
        userRepository.save(user);
        return "User added successfully";
    }

    public List<User> fetchUsers(User user) {
        return userRepository.findAll();
    }

}