package com.wstrater.lab4.common.client;

import java.net.URI;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * The common client that retrieves one of the possible words from a list of
 * words specified by the configuration based on the profile.
 * <p/>
 * Use of <code>sentence</code> profile and flag is not appropriate use of
 * profiles since it uses different logic.
 * 
 * @author wstrater
 *
 */
@RestController
public class CommonClientController {

  final private Logger    logger = LoggerFactory.getLogger(getClass());

  @Value("${spring.application.name}")
  private String          appName;

  @Value("${spring.cloud.config.uri}")
  private String          configURI;

  @Value("${eureka.client.serviceUrl.defaultZone:}")
  private String          defaultZone;

  @Autowired
  private DiscoveryClient discoveryClient;

  @Autowired
  private PortListener    listener;

  @Value("${server.port}")
  private int             port;

  @Value("${spring.profiles.active}")
  private String          profile;

  @Value("${sentence}")
  private boolean         sentence;

  @Value("${words}")
  private String          words;

  /**
   * Choose a word from the list of words when not running as
   * <code>sentence</code>.
   * 
   * @return
   */
  private String chooseWord() {
    String ret;
    String[] wordArray = words.split(",");
    int index = (int) Math.round(Math.random() * (wordArray.length - 1));
    ret = wordArray[index];

    logger.info("Lab 4 Chosen Word {}/{}: {}", profile, listener.getPort(), ret);

    return ret;
  }

  /**
   * Build a sentence from multiple services when running as
   * <code>sentence</code>.
   * 
   * @return
   */
  private String createSentence() {
    return String.format("%s %s %s %s %s.", retrieveWord("LAB-4-SUBJECT"), retrieveWord("LAB-4-VERB"),
        retrieveWord("LAB-4-ARTICLE"), retrieveWord("LAB-4-ADJECTIVE"), retrieveWord("LAB-4-NOUN"));
  }

  @RequestMapping("/")
  public @ResponseBody String get() {
    return sentence ? createSentence() : chooseWord();
  }

  @PostConstruct
  private void postConstruct() {
    logger.info(String.format("Lab 4 Common Client - %s:%d %b,%s", profile, port, sentence, words));
    logger.info(String.format("Lab 4 Common Client - appName: %s", appName));
    logger.info(String.format("Lab 4 Common Client - configURI: %s", configURI));
    logger.info(String.format("Lab 4 Common Client - defaultZone: %s", defaultZone));
  }

  /**
   * Retrieve a word from a service when running as <code>sentence</code>.
   * 
   * @param serviceName
   * @return
   */
  private Object retrieveWord(String serviceName) {
    String ret = null;

    List<ServiceInstance> serviceList = discoveryClient.getInstances(serviceName);
    if (serviceList != null && !serviceList.isEmpty()) {
      int index = (int) Math.round(Math.random() * (serviceList.size() - 1));
      URI uri = serviceList.get(index).getUri();
      if (uri != null) {
        logger.info("Lab 4 Retrieving Word {} from {} of {}: {}", serviceName, index, serviceList.size(), uri);

        ret = (new RestTemplate()).getForObject(uri, String.class);

        logger.info("Lab 4 Retrieved Word {} from {}: {}", serviceName, uri, ret);
      }
    }

    return ret;
  }

}