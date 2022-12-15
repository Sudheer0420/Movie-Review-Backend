package com.example.MovieReview.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Movie {
	@Id
	@GeneratedValue
	private int id;
	private String moviename;
	@Lob
	private String image;
	private String hero;
	private String heroine;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getHero() {
		return hero;
	}
	public void setHero(String hero) {
		this.hero = hero;
	}
	public String getHeroine() {
		return heroine;
	}
	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}
	public Movie(int id,String moviename, String image, String hero, String heroine) {
		super();
		this.id = id;
		this.moviename = moviename;
		this.image = image;
		this.hero = hero;
		this.heroine = heroine;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
