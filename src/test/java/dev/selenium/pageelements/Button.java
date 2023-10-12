package dev.selenium.pageelements;

import org.openqa.selenium.WebDriver;

public class Button extends BasicElement {

    public Button(String xPath, WebDriver driver) {
        super(xPath, driver);
    }

    public void clickOnButton() {
        findElement().click();
    }
}
