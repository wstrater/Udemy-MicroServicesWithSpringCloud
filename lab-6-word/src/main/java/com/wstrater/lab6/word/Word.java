package com.wstrater.lab6.word;

public class Word {

  private String word;

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
    StringBuilder builder = new StringBuilder();
    builder.append("Word [word=").append(word).append("]");
    return builder.toString();
  }

}