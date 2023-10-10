package dev.selenium.pages.commonpageelements;

import dev.selenium.pageelements.Link;
import dev.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class NavBar extends BasePage {
    private final Link downloads = new Link("//a[@href='/downloads']", getDriver());

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public void clickOnDownloadsLink() {
        downloads.click();
    }
}
