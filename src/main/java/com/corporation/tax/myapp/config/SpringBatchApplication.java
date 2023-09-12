package com.corporation.tax.myapp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
public class SpringBatchApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBatchApplication.class, args);
  }
}
