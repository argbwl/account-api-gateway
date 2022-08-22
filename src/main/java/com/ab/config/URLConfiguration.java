package com.ab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ab.component.AmsUrlComponent;
import com.ab.logger.APILogger;

@Configuration
public class URLConfiguration {
	
	private final static APILogger logger = APILogger.getLogger(URLConfiguration.class);
	
	@Autowired
	private AmsUrlComponent amsUrlComponent;
	
	@Bean
	public String getAMSUrl() {
		return amsUrlComponent.getAMSUrl();
	}
	
	
}
