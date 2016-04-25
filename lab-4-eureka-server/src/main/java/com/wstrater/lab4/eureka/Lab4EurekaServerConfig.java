package com.wstrater.lab4.eureka;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Lab4EurekaServerConfig {

  final private Logger logger = LoggerFactory.getLogger(getClass());

  @Value("${spring.application.name}")
  private String       appName;

  @Value("${eureka.client.serviceUrl.defaultZone:UNKNOWN}")
  private String       defaultZone;

  @Value("${eureka.client.fetchRegistry:false}")
  private boolean      fetchRegistry;

  @Value("${eureka.client.registerWithEureka:false}")
  private boolean      registerWithEureka;

  @PostConstruct
  private void postConstruct() {
    logger.info(String.format("Lab 4 Eureka Server - %b,%b", fetchRegistry, registerWithEureka));
    logger.info(String.format("Lab 4 Eureka Server - appName: %s", appName));
    logger.info(String.format("Lab 4 Eureka Server - defaultZone: %s", defaultZone));
  }

}