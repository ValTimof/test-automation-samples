package com.github.timofeevvr.test.automation.samples;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class ExampleService {

    @Value("${example.parameter}")
    private String parameter;

    public void printParameter() {
        System.out.println(parameter);
    }
}
