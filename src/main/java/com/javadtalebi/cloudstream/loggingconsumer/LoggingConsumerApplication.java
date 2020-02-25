package com.javadtalebi.cloudstream.loggingconsumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class LoggingConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggingConsumerApplication.class, args);
    }

    /*
    You can write a Spring Cloud Stream application by simply writing functions and exposing them as `@Bean`s.
    You can also use Spring Integration annotations based configuration or Spring Cloud Stream annotation based configuration,
    although starting with spring-cloud-stream 3.x we recommend using functional implementations.
   */

    @Bean
    public Consumer<Person> log() {
        return person -> {
            System.out.println("Received: " + person);
        };
    }

    public static class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }


}
