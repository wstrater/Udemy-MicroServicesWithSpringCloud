package com.wstrater.lab6.sentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Lab6SentenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab6SentenceApplication.class, args);
	}

}