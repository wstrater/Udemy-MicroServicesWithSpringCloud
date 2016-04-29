package com.wstrater.lab6.word;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

  final private Logger logger = LoggerFactory.getLogger(getClass());

  @Value("${word.delay:0}")
  private int          delay;

  @Value("${spring.profiles.active}")
  private String       profile;

  @Value("${words}")
  private String       words;

  @RequestMapping("/")
  public @ResponseBody Word getWord() {
    Word ret = null;

    String[] wordArray = words.split(",");
    int index = (int) Math.round(Math.random() * (wordArray.length - 1));
    ret = new Word(wordArray[index]);

    if (delay > 0) {
      try {
        Thread.sleep(delay + new Random().nextInt(delay));
      } catch (InterruptedException ee) {
        logger.error("Sleep", ee);
      }
    }

    logger.info("Lab 6 Chosen Word {}: {}", profile, ret);

    return ret;
  }

}