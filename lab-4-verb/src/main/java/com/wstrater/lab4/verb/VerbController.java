package com.wstrater.lab4.verb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerbController {

  @Value("${words}")
  private String verbs;

  @RequestMapping("/")
  public @ResponseBody String getVerb() {
    String[] verbArray = verbs.split(",");
    int index = (int) Math.round(Math.random() * (verbArray.length - 1));
    return verbArray[index];
  }

}