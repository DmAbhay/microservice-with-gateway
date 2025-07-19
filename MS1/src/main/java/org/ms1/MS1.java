package org.ms1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MS1 {
    public static void main(String[] args) {
        SpringApplication.run(MS1.class, args);
        System.out.printf("Hello and welcome!");

    }
}