package com.TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber"},glue={"com.automation"})
@SpringBootApplication
@Configuration
class Runner {
  public static void main(String[] args) {
    SpringApplication.run(Runner.class, args);
  }
}
