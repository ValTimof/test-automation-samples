package com.github.timofeevvr.test.automation.samples.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.common.config.TopicConfig.*;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.topicName}")
    private String myTopicName;

    @Bean
    public Map<String, String> topicConfig() {
        Map<String, String> defaultConfig = new HashMap<>();
        defaultConfig.put(DELETE_RETENTION_MS_CONFIG, "14400000");
        defaultConfig.put(FILE_DELETE_DELAY_MS_CONFIG, "30000");
        defaultConfig.put(RETENTION_MS_CONFIG, "28800000");
        defaultConfig.put(SEGMENT_MS_CONFIG, "28800000");
        return defaultConfig;
    }

    @Bean
    public NewTopic testTopic() {
        final NewTopic newTopic = new NewTopic(myTopicName, 1, (short) 1);
        newTopic.configs(topicConfig());
        return newTopic;
    }

    @Bean
    public AdminClient adminClient(KafkaAdmin admin) {
        return AdminClient.create(admin.getConfigurationProperties());
    }
}
