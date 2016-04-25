package com.wstrater.lab4.common.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Used to access the actual port used by the embedded server which is randomly
 * assigned at run-time.
 * 
 * @author wstrater
 *
 */
@Component
public class Lab4EmbededServletApplicationListener implements ApplicationListener<EmbeddedServletContainerInitializedEvent>, PortListener {

  final private Logger logger = LoggerFactory.getLogger(getClass());
  private int          port;

  @Override
  public int getPort() {
    return port;
  }

  @Override
  public void onApplicationEvent(final EmbeddedServletContainerInitializedEvent event) {
    port = event.getEmbeddedServletContainer().getPort();
    logger.info("Embedded Port: {}", port);
  }

}