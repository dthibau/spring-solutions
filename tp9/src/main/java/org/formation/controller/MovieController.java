package org.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.formation.model.Movie;
import org.formation.model.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	MovieRepository movieRepository;

	@GetMapping
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	@GetMapping("/{id}")
	public Movie findById(@PathVariable("id") long id) throws MovieNotFoundException {

		return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No such Movie"));
	}	
	@GetMapping("/director")
	public List<Movie> findByDirector(@RequestParam("q") String director) throws Exception {

		return movieRepository.findByDirectorIgnoreCase(director);
	}
	
	@GetMapping("/directorAndDate")
	public List<Movie> findByDirectorAndDate(@RequestParam("q") String director, @RequestParam("y") int year) throws Exception {

		return movieRepository.findByDirectorIgnoreCaseAndDateParution(director,year);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById( @PathVariable("id") long id) throws MovieNotFoundException {
		Movie m = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No such Movie"));
		movieRepository.delete(m);
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<Movie> create(@Valid @RequestBody Movie movie) {
		
		
		movie = movieRepository.save(movie);
		
		return new ResponseEntity<>(movie,HttpStatus.CREATED);
	}
	
	
}
