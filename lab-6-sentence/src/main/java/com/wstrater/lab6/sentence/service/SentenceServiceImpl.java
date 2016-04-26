package com.wstrater.lab6.sentence.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wstrater.lab6.sentence.client.AdjectiveClient;
import com.wstrater.lab6.sentence.client.ArticleClient;
import com.wstrater.lab6.sentence.client.NounClient;
import com.wstrater.lab6.sentence.client.SubjectClient;
import com.wstrater.lab6.sentence.client.VerbClient;

@Service
public class SentenceServiceImpl implements SentenceService {

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

  @Override
  public String buildSentence() {
    String ret = null;

    ret = String.format("%s %s %s %s %s.", subject.getWord(), verb.getWord(), article.getWord(), adjective.getWord(),
        noun.getWord());

    logger.info("Lab 6 Built Sentence: {}", ret);

    return ret;
  }

}
