package com.ab.cloud.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.ab.pojo.OpenAccountRequest;

@FeignClient(value="feignAMSClient", url = "#{getAMSUrl}")
public interface AMSystemServiceFeignConfig {

	@PostMapping("/fetchNewActNum")
	public ResponseEntity<String> fetchNewAccountNoPost(OpenAccountRequest accountRequest);
	
}
