package com.satya.secureapp.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.satya.secureapp.Model.User;
import com.satya.secureapp.Services.UserService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Greet {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/Hola")
    public String greet(HttpServletRequest request) {
        return "Hello, welcome to the secure app! " + request.getSession().getId();
    }

    @DeleteMapping("/{id}")
    public User loginToSystem(@PathVariable int id) {
        return userService.removeUser(id);
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/signup")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    

    @PostMapping("/login")
    public String loginToSystem(@RequestBody User user) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()) {
            
            
            return "Successfully logged in!";}
        else {return "Login failed!";}
    }
}