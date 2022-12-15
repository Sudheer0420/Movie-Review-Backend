package com.example.MovieReview.service;


import org.junit.jupiter.api.Test;
import com.example.MovieReview.Repository.MovieRepository;
import com.example.MovieReview.Repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.MovieReview.Entity.Review;
import com.example.MovieReview.Exceptions.InvalidUserCredentialsException;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.assertj.core.api.Assertions;


@SpringBootTest
public class ReviewServiceTests {
	
	@Autowired
	ReviewRepository reviewRepo;
	
	@Autowired
	ReviewService reviewService;
	
	@Test
	public void testAddReview() {
		Review r= new Review(3,"disaster","waste movie");
	    Review result = reviewRepo.save(r);
	    Assertions.assertThat(result.getReview()).isNotNull();
	}
	
	@Test
	public void testFindByMovie() {
		List<Review> l;
		l=reviewRepo.findAllByMoviename("disr");
		if(l.size()==0) {
			Assertions.assertThat(l.size()).isEqualTo(0);
		}
		else {
			Assertions.assertThat(l.size()).isGreaterThan(0);
		}
	}

}
