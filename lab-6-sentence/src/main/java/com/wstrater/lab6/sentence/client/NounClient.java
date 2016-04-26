package com.wstrater.lab6.sentence.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("NOUN")
public interface NounClient {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Word getWord();

}