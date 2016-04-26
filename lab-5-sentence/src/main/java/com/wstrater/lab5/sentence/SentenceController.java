package com.wstrater.lab5.sentence;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {

  final private Logger       logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private LoadBalancerClient loadBalancer;

  @RequestMapping("/")
  public @ResponseBody String get() {
    return String.format("%s %s %s %s %s.", retrieveWord("LAB-5-SUBJECT"), retrieveWord("LAB-5-VERB"),
        retrieveWord("LAB-5-ARTICLE"), retrieveWord("LAB-5-ADJECTIVE"), retrieveWord("LAB-5-NOUN"));
  }

  /**
   * Retrieve a word from a service when running as <code>sentence</code>.
   * 
   * @param serviceName
   * @return
   * @throws URISyntaxException
   */
  private Object retrieveWord(String serviceName) {
    String ret = null;

    ServiceInstance instance = loadBalancer.choose(serviceName);
    if (instance != null) {
      try {
        URI uri = new URI(String.format("%s/", instance.getUri().toString()));

        logger.info("Lab 5 Retrieving Word {}: {}", serviceName, uri);

        ret = (String) new RestTemplate().getForObject(uri, String.class);

        logger.info("Lab 5 Retrieved Word {} from {}: {}", serviceName, uri, ret);
      } catch (URISyntaxException ee) {
        logger.error(String.format("Unable to retrieve word: %s", serviceName), ee);
      }
    }

    return ret;
  }

}