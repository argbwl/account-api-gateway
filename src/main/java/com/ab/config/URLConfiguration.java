package com.ab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.ab.constant.APIConstant;
import com.ab.entity.UrlConfigEntity;
import com.ab.logger.APILogger;
import com.ab.repo.UrlConfigRepo;

@Configuration
public class URLConfiguration {
	
	private final static APILogger logger = APILogger.getLogger(URLConfiguration.class);
	
	@Autowired
	private UrlConfigRepo urlConfigRepo;
	
	@Autowired
	private Environment env;
	
	@Bean
	@Scope(value = "prototype")
	public String getAMSUrl() {
		UrlConfigEntity urlEntity = urlConfigRepo.findByUri(APIConstant.AMS_URL);
		String url=null;
		if (urlEntity != null) {
			url=urlEntity.getUrl();
			logger.info("Retrived URL [{}] from DB for URI: {}",url,APIConstant.AMS_URL);
			return url;
		}
		url=env.getProperty(APIConstant.AMS_URL);
		logger.info("Retrived URL [{}] from properties file for URI: {}",url,APIConstant.AMS_URL);
		return url;
	}
	
}
