package com.wstrater.lab7.sentence.service;

import com.wstrater.lab7.sentence.client.Word;

public interface WordService {

  public Word getAdjective();

  public Word getArticle();

  public Word getNoun();

  public Word getSubject();

  public Word getVerb();

}