package de.com.schulte.intoleranztagebuch.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import de.com.schulte.intoleranztagebuch.rest.config.controller.RestController;

@EnableWebMvc
@Configuration
public class ServletConfig {

	@Bean
	public RestController restController() {
		return new RestController();
	}

}
