package dev.selenium.pages;

import dev.selenium.pages.commonpageelements.NavBar;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private NavBar navBar;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
