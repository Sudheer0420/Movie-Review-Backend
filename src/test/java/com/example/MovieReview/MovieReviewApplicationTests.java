package com.example.MovieReview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class MovieReviewApplicationTests {
	private Calculator c= new Calculator();

	@Test
	void contextLoads() {
	}
	
	@Test
	void testSum() {
		int expectedResult=18;
		int actualResult=c.doSum(12,3,3);
		assertEquals(actualResult,expectedResult);
	}

}
