package com.wstrater.lab7.sentence.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wstrater.lab7.sentence.client.AdjectiveClient;
import com.wstrater.lab7.sentence.client.ArticleClient;
import com.wstrater.lab7.sentence.client.NounClient;
import com.wstrater.lab7.sentence.client.SubjectClient;
import com.wstrater.lab7.sentence.client.VerbClient;
import com.wstrater.lab7.sentence.client.Word;

@Service
public class WordServiceImpl implements WordService {

  final private Logger    logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private AdjectiveClient adjective;

  @Autowired
  private ArticleClient   article;

  @Autowired
  private NounClient      noun;

  @Autowired
  private SubjectClient   subject;

  @Autowired
  private VerbClient      verb;

  @HystrixCommand(fallbackMethod = "getAdjectiveFallack", threadPoolKey="Adjective")
  @Override
  public Word getAdjective() {
    Word ret = adjective.getWord();

    logger.info(String.format("getAdjective: %s", ret));

    return ret;
  }

  public Word getAdjectiveFallack() {
    logger.error("Falling Back: getAdjective");

    return new Word("missing");
  }

  @HystrixCommand(threadPoolKey="Article")
  @Override
  public Word getArticle() {
    Word ret = article.getWord();

    logger.info(String.format("getArticle: %s", ret));

    return ret;
  }

  @HystrixCommand(fallbackMethod = "getNounFallback", threadPoolKey="Noun")
  @Override
  public Word getNoun() {
    Word ret = noun.getWord();

    logger.info(String.format("getNoun: %s", ret));

    return ret;
  }

  @SuppressWarnings("unused")
  private Word getNounFallback() {
    logger.error("Falling Back: getNoun");

    return new Word("something");
  }

  @HystrixCommand(fallbackMethod = "getSubjectFallack", threadPoolKey="Subject")
  @Override
  public Word getSubject() {
    Word ret = subject.getWord();

    logger.info(String.format("getSubject: %s", ret));

    return ret;
  }

  protected Word getSubjectFallack() {
    logger.error("Falling Back: getSubject");

    return new Word("Someone");
  }

  @HystrixCommand(threadPoolKey="Verb")
  @Override
  public Word getVerb() {
    Word ret = verb.getWord();

    logger.info(String.format("getVerb: %s", ret));

    return ret;
  }

}