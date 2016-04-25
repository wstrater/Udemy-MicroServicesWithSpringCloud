package com.wstrater.lab4.sentence;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping("/")
  public @ResponseBody String getSentence() {
    return String.format("%s %s %s %s %s.", getWord("LAB-4-SUBJECT"), getWord("LAB-4-VERB"), getWord("LAB-4-ARTICLE"),
        getWord("LAB-4-ADJECTIVE"), getWord("LAB-4-NOUN"));
  }

  private String getWord(String serviceName) {
    String ret = null;

    List<ServiceInstance> serviceList = discoveryClient.getInstances(serviceName);
    if (serviceList != null && serviceList.size() > 0) {
      int index = (int) Math.round(Math.random() * (serviceList.size() - 1));
      URI uri = serviceList.get(index).getUri();
      if (uri != null) {
        ret = (new RestTemplate()).getForObject(uri, String.class);
      }
    }

    return ret;
  }

}