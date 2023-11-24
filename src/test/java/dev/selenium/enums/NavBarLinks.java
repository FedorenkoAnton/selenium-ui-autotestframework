package dev.selenium.enums;

import java.util.Arrays;
import java.util.Objects;

public enum NavBarLinks {
    DOWNLOADS("Downloads"),
    DOCUMENTATION("Documentation"),
    PROJECTS("Projects");

    private final String value;

    NavBarLinks(String value) {
        this.value = value;
    }

    public static NavBarLinks from(String NavBarLinksValue) {
        return Arrays.stream(NavBarLinks.values())
                .filter(link -> Objects.equals(link.value, NavBarLinksValue))
                .findFirst()
                .orElseThrow();
    }
}
