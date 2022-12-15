package com.example.MovieReview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieReview.Entity.Review;
import com.example.MovieReview.Repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository repo;
	
	public List<Review> findbymovie(String moviename){
		return repo.findAllByMoviename(moviename);
	}
	public String addreview(Review review) {
		repo.save(review);
		 return "review added successfully";
	}
}
