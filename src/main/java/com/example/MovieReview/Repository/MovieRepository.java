package com.example.MovieReview.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MovieReview.Entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{
	
	public void deleteByMoviename(String moviename);
	public Movie findByMoviename(String moviename);
	public Movie findById(int id);
	public boolean existsById(int id);
	
}
