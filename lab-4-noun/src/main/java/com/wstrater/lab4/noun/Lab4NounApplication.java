package com.wstrater.lab4.noun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * An application that registers with Eureka and returns an noun.
 * 
 * @see <a
 *      href="https://github.com/kennyk65/Microservices-With-Spring-Student-Files/blob/master/LabInstructions/Lab%204.md">Lab
 *      4</a>
 * 
 * @author wstrater
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Lab4NounApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4NounApplication.class, args);
	}
	
}