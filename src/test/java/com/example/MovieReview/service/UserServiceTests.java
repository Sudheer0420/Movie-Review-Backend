package com.example.MovieReview.service;

import org.junit.jupiter.api.Test;
import com.example.MovieReview.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.MovieReview.Entity.User;
import com.example.MovieReview.Exceptions.InvalidUserCredentialsException;

import static org.junit.Assert.assertEquals;
import org.assertj.core.api.Assertions;

@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private UserRepository userRepos;
	
	@Test
	public void userLogin() {
		
		User user = userRepos.findById("karthik").get();
	  	String passw = user.getPassword();
	  	System.out.println(passw);
	  		if(passw.equals("password12")) {
	  		System.out.println("login successful");
	  		}
	  		else {
	  		System.out.println("not a correct one");
	  		Assertions.assertThat(passw).isNotEqualTo("password123");
	  	}
	}
	
	@Test
	public void testSignUp() {
		User user=new User("harshi","harshi@gmail.com","pass","admin");
		User result = userRepos.save(user);
		Assertions.assertThat(result.getUsername()).isNotNull();
	}
	
	@Test
	public void testGetById(){
		User user = userRepos.findById("karthik").get();
		System.out.println(user);
		try {
		if(user!=null) {
			System.out.println("got the details");
		}
		}
		catch(Exception e) {
			System.out.println("no such user exists");
		}
	}
	
	@Test
	public void testDeleteUser() {
		if(userRepos.findById("karthik").isPresent()) {
    		userRepos.deleteById("karthik");
    		Assertions.assertThat(userRepos.existsById("karthik")).isNull();
    	}
    	else {
    		Assertions.assertThat(userRepos.existsById("karthik")).isNull();
    	}
	}
	
	@Test
	public void testGetAll() {
		Assertions.assertThat(userRepos.findAllByRole("user")).isNotNull();
	}
	
	
	@Test
	public void testUpdateUser() {
		User user = new User("karthik","karthik","karthk","user");
		User result = userRepos.save(user);
		Assertions.assertThat(result.getEmail()).isEqualTo("karthk");
	}
	

	@Test
	public void testUserExists() {
		Assertions.assertThat(userRepos.existsById("karthik")).isNotNull();
	}
	
	@Test
	public void testConvertUserToUserDto() {
		
	}

}






