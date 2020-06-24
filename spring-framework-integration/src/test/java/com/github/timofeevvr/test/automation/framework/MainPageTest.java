package com.github.timofeevvr.test.automation.framework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = MainPage.class)
public class MainPageTest {

    @Autowired
    MainPage mainPage;
    @Autowired
    ExampleService exampleService;

    @Test
    void checkSpring() {
        assertEquals("text", mainPage.getText());

    }
}
