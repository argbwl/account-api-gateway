package com.ab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ab.logger.APILogger;

@SpringBootApplication
@EnableFeignClients
public class AccountApiGatewayApplication implements CommandLineRunner{
	
	private static APILogger apiLogger = APILogger.getLogger(AccountApiGatewayApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(AccountApiGatewayApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
