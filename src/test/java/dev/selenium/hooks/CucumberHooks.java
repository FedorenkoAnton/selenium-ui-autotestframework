package dev.selenium.hooks;

import dev.selenium.containers.WebDriverContainer;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberHooks {

    private final WebDriverContainer webDriverContainer;

    public CucumberHooks(WebDriverContainer webDriverContainer) {
        this.webDriverContainer = webDriverContainer;
    }

    @After(order = 1)
    public void tearDown() {
        webDriverContainer.getDriver().quit();
    }

    @After(order = 2)
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) webDriverContainer.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
