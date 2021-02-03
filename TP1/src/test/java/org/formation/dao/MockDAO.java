package org.formation.dao;

import java.util.ArrayList;
import java.util.List;

import org.formation.model.Movie;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mock")
public class MockDAO implements MovieDAO {

	static List<Movie> movies;

	static {
		Movie m1 = new Movie();
		m1.setDirector("HitchCock");
		Movie m2 = new Movie();
		m2.setDirector("HitchCock");
		movies = new ArrayList<>();
		movies.add(m1);
		movies.add(m2);
	}

	@Override
	public List<Movie> findAll() {
		return movies;
	}

}
