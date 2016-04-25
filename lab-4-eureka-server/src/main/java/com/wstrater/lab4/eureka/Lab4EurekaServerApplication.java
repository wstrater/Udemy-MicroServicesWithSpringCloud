package com.wstrater.lab4.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * This is a Eureka server. The Spring Config server was added as part of the
 * bonus.
 * 
 * @see <a
 *      href="https://github.com/kennyk65/Microservices-With-Spring-Student-Files/blob/master/LabInstructions/Lab%204.md">Lab
 *      4</a>
 * 
 * @author wstrater
 *
 */
@SpringBootApplication
@EnableEurekaServer
@EnableConfigServer
public class Lab4EurekaServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lab4EurekaServerApplication.class, args);
  }

}