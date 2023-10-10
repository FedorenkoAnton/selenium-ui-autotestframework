package dev.selenium.enums;

import java.util.Arrays;
import java.util.Objects;

public enum WebBrowsers {
    CHROME("Chrome"),
    FIREFOX("Firefox"),
    EDGE("Edge");

    private final String value;

    WebBrowsers(String value) {
        this.value = value;
    }

    public static WebBrowsers from(String webBrowserValue) {
        return Arrays.stream(WebBrowsers.values())
                .filter(browser -> Objects.equals(browser.value, webBrowserValue))
                .findFirst()
                .orElseThrow();
    }
}
