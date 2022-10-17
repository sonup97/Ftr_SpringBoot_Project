package com.infy.ftr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:ValidationMessages.properties")
public class VehicleFtrApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleFtrApplication.class, args);
	}

}
