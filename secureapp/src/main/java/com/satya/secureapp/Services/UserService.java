package com.satya.secureapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.satya.secureapp.Model.User;
import com.satya.secureapp.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User fetchUser(User user) {
        return userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public User removeUser(int id) {
        User user = userRepo.findById(id).orElse(null);
        if (user != null) {
            userRepo.delete(user);
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
