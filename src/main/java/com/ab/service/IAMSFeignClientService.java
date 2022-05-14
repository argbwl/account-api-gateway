package com.ab.service;

import org.springframework.http.ResponseEntity;

import com.ab.pojo.OpenAccountRequest;

public interface IAMSFeignClientService {
	
	public ResponseEntity<String> fetchNewAccountNo(OpenAccountRequest accountRequest);

}
