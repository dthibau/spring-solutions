package org.formation;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.formation.model.Movie;
import org.formation.model.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("prod")
class Tp9ApplicationTests {
	
	@Autowired
	MovieRepository movieRepository;
	

	@Test
	void contextLoads() {
	}

	@Test
	public void repositoryTests() {
		
		List<Movie> hitchcock = movieRepository.findByDirectorIgnoreCase("Hitchcock");
		List<Movie> HITCHCOCK = movieRepository.findByDirectorIgnoreCase("HITCHCOCK");
		assertEquals(hitchcock.size(), 2);
		assertEquals(HITCHCOCK.size(), 2);
		List<Movie> one = movieRepository.findByDirectorIgnoreCaseAndDateParution("HITCHCOCK",1954);
		assertEquals(one.size(), 1);

	}
	
	@Test
	public void findAllTests() {
		List<Movie> movies = movieRepository.findAll();
	}
	
	@Test
	public void insertTest() {
		Movie m = new Movie();
		m.setDateParution(2021);
		m.setDirector("Jim Jarmush");
		m.setTitle("Un titre");
		m.setDuration(120);
		
		
		movieRepository.save(m);
		
	}
}
