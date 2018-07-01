package com.multicert;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;	
import com.multicert.manager.IItineraryManager;
import com.multicert.manager.ItineraryManager;

@Configuration
public class AppConfig {
	@Bean
	public IItineraryManager getMulticertManager() {
		return new ItineraryManager();
	}
}