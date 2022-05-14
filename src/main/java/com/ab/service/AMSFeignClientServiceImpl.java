package com.ab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ab.cloud.config.AMSystemServiceFeignConfig;
import com.ab.logger.APILogger;
import com.ab.pojo.OpenAccountRequest;

@Service
public class AMSFeignClientServiceImpl implements IAMSFeignClientService {

	private static APILogger amsServiceLogger = APILogger.getLogger(AMSFeignClientServiceImpl.class);
	
	@Autowired
	private AMSystemServiceFeignConfig amsServiceFeignConfig;
	
	@Override
	public ResponseEntity<String> fetchNewAccountNo(OpenAccountRequest accountRequest) {
		ResponseEntity<String> resEntity = amsServiceFeignConfig.fetchNewAccountNoPost(accountRequest);
		if (resEntity != null && HttpStatus.OK.equals(resEntity.getStatusCode())) {
			amsServiceLogger.info("Got success response from URI {}",resEntity.getBody());
			return new ResponseEntity<String>(resEntity.getBody(),HttpStatus.OK);
		}else {
			amsServiceLogger.info("Got failed response from URI {}");
			return new ResponseEntity<String>(resEntity.getBody(),resEntity.getStatusCode());
		}
	}

}
