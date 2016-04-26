package com.wstrater.lab7.sentence.service;

import com.wstrater.lab7.sentence.client.Word;

public interface WordService {

  public Word getAdjective();

  public Word getArticle();

  public String getNoun();

  public String getSubject();

  public String getVerb();

}