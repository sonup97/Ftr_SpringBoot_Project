package com.tm1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Terminal1MsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Terminal1MsApplication.class, args);
	}

}
