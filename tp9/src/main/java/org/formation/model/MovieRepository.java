package org.formation.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	public List<Movie> findByDirectorIgnoreCase(String director);

	public List<Movie> findByDirectorIgnoreCaseAndDateParution(String director, int dateParution);

}
