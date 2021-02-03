package org.formation.service;

import java.util.List;

import org.config.FileConfiguration;
import org.config.MockConfiguration;
import org.formation.model.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class MovieListerTest extends TestCase {

	public void testDirectedBy() {

		//Initialiser Spring

		ApplicationContext context = new ClassPathXmlApplicationContext("org/formation/service/test.xml");
		
		// Récupérer le bean de type MovieLister

		MovieLister movieLister = (MovieLister)context.getBean("myLister");
		
	
		List<Movie> hitchcock = movieLister.moviesDirectedBy("Hitchcock");
		List<Movie> HITCHCOCK = movieLister.moviesDirectedBy("HITCHCOCK");
		assertEquals(hitchcock.size(), 2);
		assertEquals(HITCHCOCK.size(), 2);
		List<Movie> empty = movieLister.moviesDirectedBy(null);
		assertNotNull(empty);
		assertEquals(0, empty.size());

		// Récupération du bean
		movieLister = (MovieLister)context.getBean("myLister");

		hitchcock = movieLister.moviesDirectedBy("Hitchcock");
		HITCHCOCK = movieLister.moviesDirectedBy("HITCHCOCK");
		assertEquals(hitchcock.size(), 2);
		assertEquals(HITCHCOCK.size(), 2);		
	}
	
	
	public void testWithFile() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FileConfiguration.class);
		
		MovieLister movieLister = (MovieLister)context.getBean(MovieLister.class);
		
		
		List<Movie> hitchcock = movieLister.moviesDirectedBy("Hitchcock");
		List<Movie> HITCHCOCK = movieLister.moviesDirectedBy("HITCHCOCK");
		assertEquals(hitchcock.size(), 2);
		assertEquals(HITCHCOCK.size(), 2);
		List<Movie> empty = movieLister.moviesDirectedBy(null);
		assertNotNull(empty);
		assertEquals(0, empty.size());
	}
	
	public void testWithMock() {
		// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MockConfiguration.class);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("mock");
		context.register(MockConfiguration.class);
		context.refresh();
		
		MovieLister movieLister = (MovieLister)context.getBean(MovieLister.class);
		
		
		List<Movie> hitchcock = movieLister.moviesDirectedBy("Hitchcock");
		List<Movie> HITCHCOCK = movieLister.moviesDirectedBy("HITCHCOCK");
		assertEquals(hitchcock.size(), 2);
		assertEquals(HITCHCOCK.size(), 2);
		List<Movie> empty = movieLister.moviesDirectedBy(null);
		assertNotNull(empty);
		assertEquals(0, empty.size());
	}

}
