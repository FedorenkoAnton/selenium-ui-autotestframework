package dev.selenium.manager;

import dev.selenium.pages.DownloadsPage;
import dev.selenium.pages.HomePage;
import dev.selenium.pages.commonpageelements.NavBar;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private final WebDriver driver;
    private final NavBar navBar;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
        this.navBar = new NavBar(driver);
    }

    public HomePage getHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.setNavBar(navBar);
        return homePage;
    }

    public DownloadsPage getDownloadPage() {
        DownloadsPage downloadsPage = new DownloadsPage(driver);
        downloadsPage.setNavBar(navBar);
        return downloadsPage;
    }
}
