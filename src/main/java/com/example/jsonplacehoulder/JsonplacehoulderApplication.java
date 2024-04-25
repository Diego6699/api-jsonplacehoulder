package com.example.jsonplacehoulder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JsonplacehoulderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonplacehoulderApplication.class, args);
	}

}
