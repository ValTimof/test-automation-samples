package com.github.timofeevvr.test.automation.samples;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(classes = { TestConfig.class, ExampleService.class })
@TestPropertySource(locations = "/application.properties")
public class MainPageTest {

    @Autowired
    MainPage mainPage;

    @Test
    void checkSpringConfiguration() {
        assertEquals("text", mainPage.getText());
    }

    @Test
    void checkProperties(@Autowired ExampleService exampleService) {
        exampleService.printParameter();
        assertEquals("value", exampleService.getParameter());
    }
}
