package com.wstrater.lab9.sentence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SentenceController {

  @RequestMapping("/")
  public String sentence() {
    return "sentence";
  }

}