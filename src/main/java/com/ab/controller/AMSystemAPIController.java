package com.ab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.logger.APILogger;
import com.ab.pojo.OpenAccountRequest;
import com.ab.service.IAMSFeignClientService;

@RestController
@RequestMapping("/feign/ams/v1")
public class AMSystemAPIController {
	
	private static APILogger apiLogger = APILogger.getLogger(AMSystemAPIController.class);
	
	@Autowired
	private IAMSFeignClientService amsServiceFeignService;

	@PostMapping("/fchNwAct")
	public ResponseEntity<String> fetchNewAccountNo(@RequestBody OpenAccountRequest accountRequest){
		apiLogger.info("Received Request to fetch account");
		return amsServiceFeignService.fetchNewAccountNo(accountRequest);
	}
	
}
