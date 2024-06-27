package com.example.sql.transaction_and_propagation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PropagationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropagationApplication.class, args);
    }
}
