package com.wstrater.lab5.word;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p/>
 * <code>-Dspring.application.instance_id=1</code>
 * <p/>
 * <code>-Dspring.application.instance_id=1</code>
 * <p/>
 * @author wstrater
 *
 */
@RestController
public class WordController {

  final private Logger    logger = LoggerFactory.getLogger(getClass());

  /** 
   * Required properties. 
   */

  @Value("${words}")
  private String          words;


  /**
   * Optional properties to display configuration.
   */

  @Value("${spring.application.name}")
  private String          appName;

  @Value("${spring.cloud.config.uri}")
  private String          configURI;

  @Value("${eureka.client.serviceUrl.defaultZone:}")
  private String          defaultZone;

  @Autowired
  private DiscoveryClient discoveryClient;

  @Value("${eureka.instance.instanceId:NONE}")
  private String          eurekaId;

  // Should be zero since it is randomly chosen after configuration.
  @Value("${server.port}")
  private int             port;

  @Value("${spring.profiles.active}")
  private String          profile;

  @Value("${spring.application.instance_id:NONE}")
  private String          springId;

  @RequestMapping("/")
  public @ResponseBody String get() {
    String ret;

    String[] wordArray = words.split(",");
    int index = (int) Math.round(Math.random() * (wordArray.length - 1));
    ret = wordArray[index];

    logger.info("Lab 5 Chosen Word {}: {}", profile, ret);

    return ret;
  }

  @PostConstruct
  private void postConstruct() {
    logger.info(String.format("Lab 5 Common Client - appName:     %s", appName));
    logger.info(String.format("Lab 5 Common Client - configURI:   %s", configURI));
    logger.info(String.format("Lab 5 Common Client - defaultZone: %s", defaultZone));
    logger.info(String.format("Lab 5 Common Client - eurekaId:    %s", eurekaId));
    logger.info(String.format("Lab 5 Common Client - profile:     %s", profile));
    logger.info(String.format("Lab 5 Common Client - port:        %d", port));
    logger.info(String.format("Lab 5 Common Client - springId:    %s", springId));
    logger.info(String.format("Lab 5 Common Client - words:       %s", words));
  }

}