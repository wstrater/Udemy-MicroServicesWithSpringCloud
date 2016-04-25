package com.wstrater.lab4.article;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

  @Value("${words}")
  private String articles;
 
  @RequestMapping("/")
  public @ResponseBody String getArticle() {
    String[] articleArray = articles.split(",");
    int index = (int)Math.round(Math.random() * (articleArray.length - 1));
    return articleArray[index];
  }
  
}