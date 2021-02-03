package org.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.formation")
public class FileConfiguration {

	
//	@Bean
//	public MovieDAO fileDao() {
//		
//		FileDAO dao = new FileDAO();
//		
//		dao.setFile("org/formation/service/movie.txt");
//		
//		return dao;
//		
//	}
}
