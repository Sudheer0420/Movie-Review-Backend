package com.example.MovieReview.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.example.MovieReview.Dto.SignIn;
import com.example.MovieReview.Dto.UserDto;
import com.example.MovieReview.Entity.User;
import com.example.MovieReview.service.UserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/signUp")
    public UserDto signUp(@RequestBody User user) {
        return userService.signup(user);
        
    }
    @PostMapping("/signIn")
    public UserDto signIn(@RequestBody SignIn signin) {
    	return userService.login(signin.getUsername(), signin.getPassword());
    }
    @GetMapping("")
    public List<User> get(){
    	return userService.getAll();   
    }

    @GetMapping("/getUser/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.getbyId(username);
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
    	return userService.updateUser(user);
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
    	return userService.deleteUser(id);
    }


}