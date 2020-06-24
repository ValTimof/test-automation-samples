package com.github.timofeevvr.test.automation.framework;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    public MainPage mainPage() {
        return new MainPage("text");
    }
}
