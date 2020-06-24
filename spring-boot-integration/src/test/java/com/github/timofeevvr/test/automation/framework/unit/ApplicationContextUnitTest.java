package com.github.timofeevvr.test.automation.framework.unit;

import com.github.timofeevvr.test.automation.framework.steps.MongoSteps;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.test.context.DynamicPropertySource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
//@SpringBootTest(properties = "spring.data.mongodb.port=222")
@SpringBootTest(properties = "spring.data.mongodb.port=222${testcontainers.mongo.port}")
//@SpringBootTest
public class ApplicationContextUnitTest {

    @Configuration
    public static class TestCfg {
//        @Bean
//        public MongoClient mongoClient2() {
//            System.out.println("3333333333333333333333333333333333333333333333333333333");
//            return MongoClients.create("mongodb://localhost:27019");
//        }

        @Autowired
        ConfigurableEnvironment environment;

        private void registerPort(String key, String port) {
            MutablePropertySources propertySources = this.environment.getPropertySources();
            MapPropertySource testProperties = (MapPropertySource) propertySources.get("Inlined Test Properties");
            Map<String, Object> source = Objects.requireNonNull(testProperties).getSource();
            source.put(key, port);
        }

        @Bean
        public String mongoPort() {
            String port = "567";
//            registerPort("spring.data.mongodb.port", port);
            registerPort("testcontainers.mongo.port", port);
            System.out.println("______________________________________________________");
            return port;
        }

        @Bean
        public MongoSteps mongoStepsTest2(MongoProperties properties) {
            System.out.println(properties.getPort());
            System.out.println("______________________________________________________");
            return new MongoSteps("test");
        }
    }

//    @Autowired
//    ApplicationContext applicationContext;
//
//    @Test
//    void getBeanDefinitionNamesTest() {
//        var beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//
//        blank();
//        Arrays.stream(beanDefinitionNames)
//                .forEach(System.out::println);
//        blank();
//
//        assertThat(beanDefinitionNames).isNotEmpty();
//
//    }

    void blank() {
        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }
    }
}
