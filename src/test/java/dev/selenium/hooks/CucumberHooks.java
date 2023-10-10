package dev.selenium.hooks;

import dev.selenium.containers.WebDriverContainer;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

public class CucumberHooks {

    private final WebDriverContainer webDriverContainer;

    public CucumberHooks(WebDriverContainer webDriverContainer) {
        this.webDriverContainer = webDriverContainer;
    }

    @After
    public void tearDown() {
        webDriverContainer.getDriver().quit();
    }
}
