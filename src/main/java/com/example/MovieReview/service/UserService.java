package com.example.MovieReview.service;

import com.example.MovieReview.Dto.UserDto;
import com.example.MovieReview.Entity.User;
import com.example.MovieReview.Exceptions.InvalidUserCredentialsException;
import com.example.MovieReview.Exceptions.UserAlreadyExistsException;
import com.example.MovieReview.Repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class UserService{
    @Autowired
    private UserRepository userRepos;


    public boolean userExists(String username) {
        return userRepos.findByUsername(username) != null;
    }

    public List<User> getAll(){
        return userRepos.findAllByRole("user");
    }
    public User getbyId(String username) {
    	return userRepos.findById(username).get();
    }
   
    public UserDto login(String username,String password) {
    	  User user = userRepos.findById(username).get();
    	  try {
    	  if(user.getPassword().equals(password))
    	  return convertUserToUserDto(user);
    	  else
    		  new InvalidUserCredentialsException("Invalid Credentials");
    	  }catch(InvalidUserCredentialsException e) {
    		  return null;
    	  }
    	  return null;
    	
    	 
    }
    public UserDto signup(User user) {
        if (userRepos.findById(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        userRepos.save(user);
        return convertUserToUserDto(user);
    }

    public UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto( user.getUsername(), user.getRole());
        return userDto;
    }
    public User updateUser(User user) {
    	if(userRepos.findById(user.getUsername()).isPresent()) {
    		
    		return userRepos.save(user);
    	}
    	else {
    		return null;
    	}
    }
    public String deleteUser(String username) {
    	if(userRepos.findById(username).isPresent()) {
    		userRepos.deleteById(username);
    		return "deleted successfully";
    	}
    	else {
    		return "user not found";
    	}
    }
}
