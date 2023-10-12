package dev.selenium.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasicElement {
    private final WebDriver driver;
    private final String xPath;

    public BasicElement(String xPath, WebDriver driver) {
        this.xPath = xPath;
        this.driver = driver;
    }

    protected WebElement findElement() {
        return this.driver.findElement(By.xpath(xPath));
    }

    protected List<WebElement> findElements() {
        return this.driver.findElements(By.xpath(xPath));
    }

    public void clickWithJsScript() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", findElement());
    }

    public String getXPath() {
        return this.xPath;
    }
}
