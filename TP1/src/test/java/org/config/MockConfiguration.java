package org.config;

import org.formation.dao.MockDAO;
import org.formation.dao.MovieDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.formation")
public class MockConfiguration {

	
//	@Bean
//	public MovieDAO mockDao() {
//		
//		return new MockDAO();
//			
//	}
}
