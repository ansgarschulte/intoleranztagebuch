package de.com.schulte.intoleranztagebuch.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
// @Import({ PersistanceConfig.class, GeoCodingConfig.class })
@ImportResource("classpath:de/com/schulte/intoleranztagebuch/rest/config/mobileApplicationContext.xml")
public class ServiceConfig {

	//
	// @Bean
	// public AgentNameSearch standardAgentNameSearch() {
	// return new StandardAgentNameSearch();
	// }

}
