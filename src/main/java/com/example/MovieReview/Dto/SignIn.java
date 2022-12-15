package com.example.MovieReview.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class SignIn {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public SignIn(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public SignIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
