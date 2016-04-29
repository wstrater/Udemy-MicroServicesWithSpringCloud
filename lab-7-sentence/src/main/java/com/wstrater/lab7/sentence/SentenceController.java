package com.wstrater.lab7.sentence;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import rx.Observable;
import rx.schedulers.Schedulers;

import com.wstrater.lab7.sentence.service.SentenceService;

@Controller
public class SentenceController {

  @Autowired
  private SentenceService sentence;

  @RequestMapping("/")
  public @ResponseBody String getSentence() {
    StringBuilder buf = new StringBuilder();

    buf.append("<h3>Some Sentences</h3>");

    AtomicInteger created = new AtomicInteger();
    AtomicInteger suspicious = new AtomicInteger();
    AtomicInteger used = new AtomicInteger();

    Observable.range(0, 10).map(xx -> {
      String ret = sentence.buildSentence();
      created.incrementAndGet();
      return ret;
    }).take(10L, TimeUnit.SECONDS).filter(sentence -> {
      boolean isSuspicious = sentence.contains("suspicious");
      if (isSuspicious)
        suspicious.incrementAndGet();
      return !isSuspicious;
    }).subscribe(sentence -> {
      buf.append(sentence).append("<br/>");
      used.incrementAndGet();
    });

    buf.append("<br/>").append(String.format("%s of %s used.", used.get(), created.get()));
    if (suspicious.get() > 0) {
      buf.append(String.format(" Found %d suspicious.", suspicious.get()));
    }

    return buf.toString();
  }
}