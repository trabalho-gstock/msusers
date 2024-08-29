package com.gstock.msusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsusersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsusersApplication.class, args);
	}

}
