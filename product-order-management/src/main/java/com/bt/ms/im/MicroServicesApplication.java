package com.bt.ms.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = { "com.bt.ms.im","com.bt.ms.im.css.createequipmentorder"})
public class MicroServicesApplication {

  public static void main(String[] args) {

    SpringApplication.run(MicroServicesApplication.class, args);
  }
}
