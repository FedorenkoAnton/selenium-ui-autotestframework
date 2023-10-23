package dev.selenium.pageelements;

import org.openqa.selenium.WebDriver;

public class Link extends BasicElement {

    public Link(String xPath, WebDriver driver) {
        super(xPath, driver);
    }
    public void clickOnLink() {
        findElement().click();
    }

    public String getText() {
        return findElement().getText();
    }
}
