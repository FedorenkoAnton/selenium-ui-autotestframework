package dev.selenium.pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ContentContainer extends BasicElement {

    public ContentContainer(String xPath, WebDriver driver) {
        super(xPath, driver);
    }

    public List<String> getListOfTextFromElements() {
        return findElements().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getElementFromContainerByIndex(int index) {
        return findElements().get(index);
    }
}
