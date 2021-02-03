package org.formation;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Tp6Application {

	private static final Logger logger = LoggerFactory.getLogger(Tp6Application.class);
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Tp6Application.class, args);
		
		Arrays.stream(context.getBeanDefinitionNames()).forEach(bd -> logger.debug(bd));
	}

}
