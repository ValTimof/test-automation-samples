package com.github.timofeevvr.test.automation.samples.steps;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestSteps {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MongoTemplate mongoTemplate;

    public TestSteps(KafkaTemplate<String, String> kafkaTemplate, MongoTemplate mongoTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.mongoTemplate = mongoTemplate;
    }
}
