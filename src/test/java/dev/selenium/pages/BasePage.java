package dev.selenium.pages;

import dev.selenium.enums.WebBrowsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public abstract class BasePage {
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitUntilVisible(long timeToWait, String xPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(timeToWait, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xPath))));
    }

    public void waitUntilExpectedNumberOfElementsPresent(long timeToWait, int numberOfElements, String xPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(timeToWait, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xPath), numberOfElements));
    }
}
