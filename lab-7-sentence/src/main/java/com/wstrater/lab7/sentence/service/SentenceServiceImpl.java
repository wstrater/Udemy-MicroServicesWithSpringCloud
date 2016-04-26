package com.wstrater.lab7.sentence.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {

  final private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private WordService  word;

  @Override
  public String buildSentence() {
    String ret = null;

    ret = String.format("%s %s %s %s %s.", word.getSubject(), word.getVerb(), word.getArticle(), word.getAdjective(),
        word.getNoun());

    logger.info("Lab 7 Built Sentence: {}", ret);

    return ret;
  }

}