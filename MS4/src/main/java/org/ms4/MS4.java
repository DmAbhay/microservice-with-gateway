package org.ms4;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MS4 {
    public static void main(String[] args) {

        SpringApplication.run(MS4.class, args);
        System.out.print("Hello and welcome!");

    }
}