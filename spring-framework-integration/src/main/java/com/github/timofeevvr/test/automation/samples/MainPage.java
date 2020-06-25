package com.github.timofeevvr.test.automation.samples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public class MainPage {
    @Getter
    private final String text;

    public MainPage(String text) {
        this.text = text;
    }
}
