package com.wstrater.lab5.word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab5WordApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lab5WordApplication.class, args);
  }

}