package com.ab.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.ab.constant.APIConstant;
import com.ab.entity.UrlConfigEntity;
import com.ab.logger.APILogger;
import com.ab.repo.UrlConfigRepo;

@Component
public class AmsUrlComponent {
	
	private final static APILogger logger = APILogger.getLogger(AmsUrlComponent.class);
	
	@Autowired
	private UrlConfigRepo urlConfigRepo;
	
	@Autowired
	private Environment env;
	
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
