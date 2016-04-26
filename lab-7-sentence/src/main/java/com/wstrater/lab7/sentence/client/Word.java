package com.wstrater.lab7.sentence.client;

public class Word {

  private String word;

  public Word() {
  }

  public Word(String word) {
    this.word = word;
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