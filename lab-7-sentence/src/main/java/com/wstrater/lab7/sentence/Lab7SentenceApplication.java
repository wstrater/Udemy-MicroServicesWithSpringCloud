package com.wstrater.lab7.sentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Access the Hystrix dash board at http://localhost:8020/hystrix using
 * http://localhost:8020/hystrix.stream as the stream. Substitute 8020 with the
 * appropriate value if using a random port number.
 * <p/>
 * 
 * @author wstrater
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class Lab7SentenceApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lab7SentenceApplication.class, args);
  }

}