package dev.selenium.pageelements;

import org.openqa.selenium.WebDriver;

public class Tab extends BasicElement {

    public Tab(String xPath, WebDriver driver) {
        super(xPath, driver);
    }

    public String getText() {
        return findElement().getText();
    }
}
