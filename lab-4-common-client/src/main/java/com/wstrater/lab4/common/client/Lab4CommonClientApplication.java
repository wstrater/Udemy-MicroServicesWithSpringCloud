package com.wstrater.lab4.common.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * This is a common client application that changes it's behavior based on the
 * profile. The profile could be adjective, article, noun, subject, verb or
 * sentence.
 * <p/>
 * The use of sentence as a profile is not a good approach since the application
 * is choosing business logic based on profile. Using the other profiles is fine
 * since it only changes the list of possible values.
 * <p/>
 * The profile must be specified at run time where profile is one of the
 * following: <code>adjective</code>, <code>article</code>, <code>noun</code>,
 * <code>sentence</code>, <code>subject</code> or <code>verb</code>.
 * <p/>
 * <code>-Dspring.profiles.active={profile}</code>
 * <p/>
 * There are several approaches to running multiple instances on one server.
 * Normally the host name is used in the instance id registered with Eureka.
 * This means that only the last instance started on the host is accessible.
 * <p/>
 * The full instance id is defined in the <code>bootstrap.yml</code>. This
 * configuration will generate a random instance id. The problem with a random
 * instance id is that Eureka will always keep track of it even after the
 * instance has been shut down.
 * <p/>
 * You can specify a unique value that is added to the instance id with the
 * following. This will allow the instance to be restarted.
 * <p/>
 * <code>-Dspring.application.instance_id={id}</code>
 * <p/>
 * The entire instance id can be overridden with the following.
 * <p/>
 * <code>-Deureka.instance.instanceId={instanceId}</code>
 * <p/>
 * This application can work with a Eureka cluster by adding a profile. Multiple
 * profiles can be specified as ',' delimited list.
 * <p/>
 * <code>-Dspring.profiles.active={profile},clustered</code>
 * <p/>
 * This application is configured to use a Config server to configure the Eureka
 * server. It was based on the bonus section of the lab.
 * 
 * @see <a
 *      href="https://github.com/kennyk65/Microservices-With-Spring-Student-Files/blob/master/LabInstructions/Lab%204.md">Lab
 *      4</a>
 * 
 * @author wstrater
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Lab4CommonClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lab4CommonClientApplication.class, args);
  }

}