package com.wstrater.lab4.adjective;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdjectiveController {

  @Value("${words}")
  private String adjectives;
 
  @RequestMapping("/")
  public @ResponseBody String getAdjective() {
    String[] adjectiveArray = adjectives.split(",");
    int index = (int)Math.round(Math.random() * (adjectiveArray.length - 1));
    return adjectiveArray[index];
  }
  
}