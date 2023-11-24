package dev.selenium.pageelements;

import org.openqa.selenium.WebDriver;

public class Heading extends BasicElement{
    public Heading(String xPath, WebDriver driver) {
        super(xPath, driver);
    }

    public String getHeadingText() {
        return super.findElement().getText();
    }
}
