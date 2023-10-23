package dev.selenium.stepdefinitions;

import dev.selenium.containers.PageFactoryContainer;
import dev.selenium.pages.GitHubSeleniumPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class GitHubSeleniumPageSteps {
    private final GitHubSeleniumPage gitHubSeleniumPage;

    public GitHubSeleniumPageSteps(PageFactoryContainer pageFactoryContainer) {
        this.gitHubSeleniumPage = pageFactoryContainer.getPageFactoryManager().getGitHubSeleniumPage();
    }

    @Then("^new tab's URL with host (.*) is open$")
    public void newTabsURLwithHostGithubcomIsOpen(String expectedUrl) {
        gitHubSeleniumPage.navigateToGitHubTab();
        assertThat(String.format("Current URL should contain %s", expectedUrl), gitHubSeleniumPage.getGitHubURL(),
                containsString(expectedUrl));
    }

    @And("^user is on (.*) repository page$")
    public void userIsOnSeleniumGithubIoRepositoryPage(String repositoryName) {
        gitHubSeleniumPage.waitUntilRepositoryNameIsVisible();
        assertThat(String.format("Repository name should be: %s", repositoryName),
                gitHubSeleniumPage.getRepositoryName(), equalTo(repositoryName));
    }
}
