package com.zjkung.resumind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.zjkung.resumind")
public class ResumindApplication {

  public static void main(String[] args) {
    SpringApplication.run(ResumindApplication.class, args);
  }

}
