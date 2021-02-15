package com.cts.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CheckinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckinServiceApplication.class, args);
	}

}
