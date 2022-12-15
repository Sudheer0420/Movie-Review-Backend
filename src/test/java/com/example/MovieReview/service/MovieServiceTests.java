package com.example.MovieReview.service;

import org.junit.jupiter.api.Test;
import com.example.MovieReview.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.MovieReview.Entity.Movie;
import com.example.MovieReview.Exceptions.InvalidUserCredentialsException;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.assertj.core.api.Assertions;


@SpringBootTest
public class MovieServiceTests {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
    private MovieRepository movieRepo;
	
	@Test
	public void testAddMovie() {
		Movie m =new Movie( 2 ,"akhil","anyone","bdjfnm","disaster");
		Movie result = movieRepo.save(m);
		Assertions.assertThat(result.getId()).isNotNull();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testDelete() {
		movieRepo.deleteById((long) 1);
		Assertions.assertThat(movieRepo.existsById((long) 1)).isNull();
	}
	
	@Test
	public void testDelete1() {
		Movie m=movieRepo.findByMoviename("akhil");
		System.out.println(m);
		movieRepo.delete(m);
		Assertions.assertThat(movieRepo.findByMoviename("disaster")).isNull();
	}
	
	@Test
	public void testGetAll() {
		List<Movie> mo;
		mo=movieRepo.findAll();
		Assertions.assertThat(mo.size()).isGreaterThanOrEqualTo(0);
	}
	
	@Test
	public void testGetMovie() {
		Movie movie = movieRepo.findById(0);
		if(movieRepo.existsById(0) == false) {
			Assertions.assertThat(movie).isNull();
		}
		else {
			Assertions.assertThat(movie.getMoviename()).isNotNull();
		}
	}
	
	@Test
	public void testGetMovie1() {
		Movie movie = movieRepo.findByMoviename("disaster");
		Assertions.assertThat(movie.getId()).isNotNull();
	}

}
