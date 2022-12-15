package com.example.MovieReview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.MovieReview.Entity.Movie;
import com.example.MovieReview.service.MovieService;

@CrossOrigin
@RequestMapping("/movie")
@RestController
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@GetMapping("/getAll")
	public List<Movie> getAllMovies(){
		return service.getAll();
		}
	@GetMapping("/byId/{id}")
	public Movie getById(@PathVariable int id){
		return service.getMovie(id);
	}
	@GetMapping("/{id}")
	public Movie getById1(@PathVariable String id){
		return service.getMovie1(id);
	}
	@PostMapping("/addmovie")
	public Movie addmovie(@RequestBody Movie movie) {
		return service.addmovie(movie);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}
	@DeleteMapping("/delete1/{id}")
	public String delete1(@PathVariable String id) {
		return service.delete1(id);
	}

	
}
