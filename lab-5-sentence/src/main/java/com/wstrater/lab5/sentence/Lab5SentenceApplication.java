package com.wstrater.lab5.sentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab5SentenceApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lab5SentenceApplication.class, args);
  }

}