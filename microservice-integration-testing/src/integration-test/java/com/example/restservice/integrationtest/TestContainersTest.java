package com.example.restservice.integrationtest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * Running docker is required to use Testcontainers
 */
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestContainersTest {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer();

    @DynamicPropertySource
    static void mongoProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.port", () -> mongoDBContainer.getMappedPort(27017));
    }

    @LocalServerPort
    String port;

    @Test
    void getResponseTest() {
        RestAssured
                .given()
                .baseUri("http://localhost:" + port)
                .when()
                .get("/greeting")
                .then()
                .statusCode(200);
    }
}
