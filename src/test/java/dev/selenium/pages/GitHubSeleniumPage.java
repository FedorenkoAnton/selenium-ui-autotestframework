package dev.selenium.pages;

import dev.selenium.browserralatedactions.TabActions;
import dev.selenium.pageelements.Link;
import org.openqa.selenium.WebDriver;

public class GitHubSeleniumPage extends BasePage {

    private final Link repositoryName = new Link(
            "//strong//a[@href='/SeleniumHQ/seleniumhq.github.io' and " +
                    "@data-turbo-frame='repo-content-turbo-frame']",
            getDriver());

    public GitHubSeleniumPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGitHubTab() {
        String title = "SeleniumHQ/seleniumhq.github.io";
        new TabActions(getDriver()).switchToNextTab(title);
    }

    public String getGitHubURL() {
        return getDriver().getCurrentUrl();
    }

    public String getRepositoryName() {
        return repositoryName.getText();
    }

    public void waitUntilRepositoryNameIsVisible() {
        waitUntilAllElementsVisible(repositoryName.getXPath());
    }
}
