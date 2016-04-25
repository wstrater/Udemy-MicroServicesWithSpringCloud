package com.wstrater.lab3.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

/**
 * This is a Spring Config server.
 * 
 * @see <a
 *      href="https://github.com/kennyk65/Microservices-With-Spring-Student-Files/blob/master/LabInstructions/Lab%203.md">Lab
 *      3</a>
 *      
 * @author wstrater
 *
 */
@SpringBootApplication
@EnableConfigServer
public class Lab3ServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lab3ServerApplication.class, args);
  }

  @PostConstruct
  public void testGit() {
    for (String uri : new String[] { "https://github.com/kennyk65/Microservices-With-Spring-Student-Files/ConfigData",
        "https://github.com/wstrater/Udemy-MicroServicesWithSpringCloud/SpringConfigData" }) {
      ClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
      try {
        ClientHttpRequest request = factory.createRequest(new URI(uri), HttpMethod.GET);
        ClientHttpResponse response = request.execute();
        System.out.println(String.format("%s: %s", uri, response.getStatusCode().name()));
        if (response.getStatusCode() == HttpStatus.OK) {
          HttpHeaders headers = response.getHeaders();
          // headers.forEach((key, values) ->
          // System.out.println(String.format("%s: %s", key,
          // values.toString())));
          BufferedReader in = new BufferedReader(new InputStreamReader(response.getBody()));
          // in.lines().forEach(line -> System.out.println(line));
          in.close();
        }
      } catch (IOException | URISyntaxException ee) {
        ee.printStackTrace();
      }
    }
  }
}