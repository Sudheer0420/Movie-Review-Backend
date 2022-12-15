package com.example.MovieReview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.MovieReview.Entity.Movie;
import com.example.MovieReview.Repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository repo;
	
	public Movie addmovie(Movie movie) {
	
		return repo.save(movie);
	}
	

	public Movie getMovie(long id) {
		return repo.findById(id).get();
	}
	public Movie getMovie1(String id) {
		return repo.findByMoviename(id);
	}
	public List<Movie> getAll(){
		return repo.findAll();
	}
	public String delete(int id) {
		repo.deleteById((long) id);
		return "movie deleted successfully";
	}
	public String delete1(String name) {
		Movie m=repo.findByMoviename(name);
		repo.delete(m);
		return "movie deleted successfully";
	}
}
