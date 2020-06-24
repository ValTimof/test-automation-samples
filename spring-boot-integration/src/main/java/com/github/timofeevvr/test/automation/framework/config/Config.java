package com.github.timofeevvr.test.automation.framework.config;

import com.github.timofeevvr.test.automation.framework.steps.MongoSteps;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

//    @Bean
//    public MongoClient myMongoClient() {
//        System.out.println("222222222222222222222222222222222222222222222222222222222222");
//        return MongoClients.create("mongodb://localhost:27018");
//    }
//    @Value("${spring.data.mongodb.port}")
    public String port;

    @Bean
    public MongoSteps mongoSteps1() {
        System.out.println("______________________________________________________");
        return new MongoSteps("main");
    }
    @Bean
    public MongoSteps mongoSteps0() {
        System.out.println("______________________________________________________");
        return new MongoSteps("main0");
    }
}
