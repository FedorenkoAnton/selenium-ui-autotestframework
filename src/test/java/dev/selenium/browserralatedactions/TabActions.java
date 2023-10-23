package dev.selenium.browserralatedactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static dev.selenium.constants.TimeConstant.TIME_TO_WAIT;

public class TabActions {
    private final WebDriver driver;

    public TabActions(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNextTab(String tabTitle) {
        String originalWindow = driver.getWindowHandle();
        waitUntilTabToBeOpen();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        waitUntilWebPageOnNewTabIsLoaded(tabTitle);
    }

    private void waitUntilTabToBeOpen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(TIME_TO_WAIT, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    private void waitUntilWebPageOnNewTabIsLoaded(String newTabTitleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(TIME_TO_WAIT, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.titleContains(newTabTitleText));
    }
}
