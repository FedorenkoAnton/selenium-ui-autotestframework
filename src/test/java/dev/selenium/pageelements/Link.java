package dev.selenium.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Link {
    private final String xPath;
    private final WebDriver driver;

    public Link(String xPath, WebDriver driver) {
        this.xPath = xPath;
        this.driver = driver;
    }

    public void click() {
        findElement().click();
    }

    private WebElement findElement() {
        return this.driver.findElement(By.xpath(this.xPath));
    }
}
