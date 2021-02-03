package org.formation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.formation.dao.MovieDAO;
import org.formation.model.Movie;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MovieLister implements ApplicationContextAware, EnvironmentAware {

	
    private final MovieDAO movieDao;
    
  
    public MovieLister(MovieDAO movieDao) {
    	this.movieDao = movieDao;
    }

	public List<Movie> moviesDirectedBy(String director) {
		
		return movieDao.findAll().stream()
				.filter(m -> m.getDirector().equalsIgnoreCase(director))
				.collect(Collectors.toList());
		
	}

	
	public void init() {
		
		System.out.println(System.currentTimeMillis());
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		for (String beanDefinitionName : applicationContext.getBeanDefinitionNames() ) {
			System.out.println(beanDefinitionName);
		}
				
	}

	@Override
	public void setEnvironment(Environment environment) {

		Arrays.stream(environment.getActiveProfiles()).forEach(System.out::println);
		
		System.out.println(environment.getProperty("file.location"));
	}
}
