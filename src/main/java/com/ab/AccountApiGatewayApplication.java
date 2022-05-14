package com.ab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccountApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApiGatewayApplication.class, args);
	}

}
