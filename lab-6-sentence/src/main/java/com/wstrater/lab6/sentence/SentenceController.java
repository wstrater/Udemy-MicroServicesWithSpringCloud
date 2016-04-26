package com.wstrater.lab6.sentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wstrater.lab6.sentence.service.SentenceService;

@Controller
public class SentenceController {

  @Autowired
  private SentenceService sentence;

  @RequestMapping("/")
  public @ResponseBody String getSentence() {
    StringBuilder buf = new StringBuilder();
    
    buf.append("<h3>Some Sentences</h3>");
    for(int xx = 0; xx < 5; xx++) {
      buf.append(sentence.buildSentence()).append("<br/>");
    }
    
    return buf.toString();
  }

}