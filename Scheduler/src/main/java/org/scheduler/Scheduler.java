package org.scheduler;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
@ComponentScan(basePackages = {
        "org.scheduler",
        "dataman.dmbase.encryptiondecryptionutil",
        "dataman.dmbase.redissessionutil",
        "dataman.dmbase.documentutil",
        "dataman.dmbase.customconfig",
        "dataman.dmbase.server",
})
public class Scheduler {
    public static void main(String[] args) {

        SpringApplication.run(Scheduler.class, args);
        System.out.print("Hello and welcome!");

    }
}