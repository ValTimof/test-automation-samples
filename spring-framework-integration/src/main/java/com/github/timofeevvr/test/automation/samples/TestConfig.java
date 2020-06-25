package com.github.timofeevvr.test.automation.samples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public MainPage mainPage() {
        return new MainPage("text");
    }
}
