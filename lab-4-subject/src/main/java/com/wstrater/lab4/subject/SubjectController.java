package com.wstrater.lab4.subject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

  @Value("${words}")
  private String subjects;
 
  @RequestMapping("/")
  public @ResponseBody String getSubject() {
    String[] subjectArray = subjects.split(",");
    int index = (int)Math.round(Math.random() * (subjectArray.length - 1));
    return subjectArray[index];
  }
  
}