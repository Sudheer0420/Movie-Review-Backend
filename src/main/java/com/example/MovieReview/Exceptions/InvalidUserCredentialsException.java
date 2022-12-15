package com.example.MovieReview.Exceptions;

public class InvalidUserCredentialsException  extends RuntimeException{
    public  InvalidUserCredentialsException(String s){
        super(s);
    }
}

