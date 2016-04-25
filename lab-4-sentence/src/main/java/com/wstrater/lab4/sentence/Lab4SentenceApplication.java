package com.wstrater.lab4.sentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * An application that registers with Eureka and returns a sentence containing a
 * subject, verb, article, adjective and noun retrieved from other applications
 * registered with Eureka.
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
public class Lab4SentenceApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lab4SentenceApplication.class, args);
  }

}