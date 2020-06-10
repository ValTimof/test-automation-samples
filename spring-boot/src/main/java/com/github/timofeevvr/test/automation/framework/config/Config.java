package com.github.timofeevvr.test.automation.framework.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27018");
    }
}
