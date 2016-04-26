package com.wstrater.lab5.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Lab5ConfigServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lab5ConfigServerApplication.class, args);
  }

}