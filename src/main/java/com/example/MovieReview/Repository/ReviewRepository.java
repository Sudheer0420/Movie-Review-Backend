package com.example.MovieReview.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MovieReview.Entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,String>{
	List<Review> findAllByMoviename(String moviename);
}
