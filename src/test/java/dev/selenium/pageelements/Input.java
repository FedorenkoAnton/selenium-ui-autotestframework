package dev.selenium.pageelements;

import org.openqa.selenium.WebDriver;

public class Input extends BasicElement {

    public Input(String xPath, WebDriver driver) {
        super(xPath, driver);
    }

    public void inputText(String text) {
        findElement().sendKeys(text);
    }
}
