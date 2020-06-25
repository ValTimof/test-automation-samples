package com.github.timofeevvr.test.automation.samples;

import com.github.timofeevvr.test.automation.samples.steps.TestSteps;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.util.Set;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@EmbeddedKafka(bootstrapServersProperty = "spring.kafka.bootstrap-servers")
@SpringBootTest
class E2ETest {

    @Autowired
    TestSteps testSteps;

    @Test
    void checkApplicationContext(@Autowired ApplicationContext applicationContext) {
        assertThat(applicationContext)
                .isNotNull();
        assertThat(applicationContext.getBeanDefinitionNames())
                .isNotEmpty();
    }

    @Test
    void checkKafkaTopics(@Autowired AdminClient adminClient) throws ExecutionException, InterruptedException {
        Set<String> topics = adminClient.listTopics().names().get();
        assertThat(topics)
                .contains("myTopic");
    }

    @Test
    void checkMongoDBConnected(@Autowired MongoTemplate mongoTemplate) {
        var collectionName = "myCollection";
        mongoTemplate.createCollection(collectionName);
        assertThat(mongoTemplate.getCollectionNames())
                .contains(collectionName);
    }
}
