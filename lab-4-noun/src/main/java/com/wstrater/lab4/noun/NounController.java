package com.wstrater.lab4.noun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NounController {

  @Value("${words}")
  private String nouns;
 
  @RequestMapping("/")
  public @ResponseBody String getNoun() {
    String[] nounArray = nouns.split(",");
    int index = (int)Math.round(Math.random() * (nounArray.length - 1));
    return nounArray[index];
  }
  
}