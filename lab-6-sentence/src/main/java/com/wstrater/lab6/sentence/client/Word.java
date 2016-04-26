package com.wstrater.lab6.sentence.client;

public class Word {

  private String word;

  public Word() {
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  @Override
  public String toString() {
    return getWord();
  }

}