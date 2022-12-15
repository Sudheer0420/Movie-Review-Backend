package com.example.MovieReview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieReview.Entity.Review;
import com.example.MovieReview.service.ReviewService;

@CrossOrigin
@RequestMapping("/review")
@RestController
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	@GetMapping("/getall/{moviename}")
	public List<Review> getAllReviews(@PathVariable String moviename){
		return service.findbymovie(moviename);
	}
	
	@PostMapping("/addreview")
	public String addreview(@RequestBody Review review) {
		return service.addreview(review);
	}
}
