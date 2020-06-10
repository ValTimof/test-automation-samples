package com.github.timofeevvr.test.automation.framework.unit;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class ApplicationContextUnitTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void getBeanDefinitionNamesTest() {
        var beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames)
                .forEach(log::info);

        assertThat(beanDefinitionNames).isNotEmpty();
    }
}
