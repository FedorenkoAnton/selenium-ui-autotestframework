package dev.selenium.manager;

import dev.selenium.pages.*;
import dev.selenium.pages.commonpageelements.NavBar;
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

    public DocumentationPage getDocumentationPage() {
        DocumentationPage documentationPage = new DocumentationPage(driver);
        documentationPage.setNavBar(navBar);
        return documentationPage;
    }

    public GitHubSeleniumPage getGitHubSeleniumPage() {
        return new GitHubSeleniumPage(driver);
    }

    public ProjectsPage getProjectsPage() {
        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.setNavBar(navBar);
        return projectsPage;
    }
}
