package dev.selenium.pages.commonpageelements;

import dev.selenium.pageelements.Button;
import dev.selenium.pageelements.Header;
import dev.selenium.pageelements.Link;
import dev.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class NavBar extends BasePage {

    private final Header header = new Header("//nav[contains(@class, 'js-navbar')]/parent::header", getDriver());
    private final Link downloads = new Link("//a[@href='/downloads']", getDriver());
    private final Link documentation = new Link("//a[@href='/documentation']", getDriver());
    private final Link projects = new Link("//a[@href='/projects']", getDriver());

    private final Button searchButton = new Button("//button[@class='DocSearch DocSearch-Button']", getDriver());

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public void clickOnDownloadsLink() {
        downloads.clickOnLink();
    }

    public void clickOnDocumentationLink() {
        documentation.clickOnLink();
    }

    public void clickOnSearchButton() {
        searchButton.clickOnButton();
    }

    public void clickOnProjectsLink() {
        projects.clickOnLink();
    }

    public Header getHeader() {
        return this.header;
    }
}
