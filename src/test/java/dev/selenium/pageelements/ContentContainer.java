package dev.selenium.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ContentContainer {
    private final WebDriver driver;
    private final String xPath;

    public ContentContainer(String xPath, WebDriver driver) {
        this.xPath = xPath;
        this.driver = driver;
    }

    public List<String> getListOfTextFromElements() {
        return findElementsByXPath().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<WebElement> findElementsByXPath() {
        return this.driver.findElements(By.xpath(xPath));
    }
}
