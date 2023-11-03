package dev.selenium.stepdefinitions;

import dev.selenium.containers.PageFactoryContainer;
import dev.selenium.enums.NavBarLinks;
import dev.selenium.manager.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class HomePageSteps {
    private final PageFactoryManager pageFactoryManager;

    public HomePageSteps(PageFactoryContainer pageFactoryManagerContainer) {
        this.pageFactoryManager = pageFactoryManagerContainer.getPageFactoryManager();
    }

    @When("^user clicks on (.*) link$")
    public void clicks_on_link(String link) {
        clickOnNavBarLink(link);
    }

    @When("user clicks on search button")
    public void userClicksOnSearchButton() {
        pageFactoryManager.getHomePage().getNavBar().clickOnSearchButton();
    }

    @And("^user input (.*) into search field$")
    public void userInputSearchQueryIntoSearchField(String searchQuery) {
        pageFactoryManager.getHomePage().waitUntilSearchInputVisible();
        pageFactoryManager.getHomePage().inputTextIntoSearchField(searchQuery);
    }

    @Then("^user sees that each suggested result contain (.*)$")
    public void userSeesThatEachSuggestedResultContainInputWord(String searchWord) {
        pageFactoryManager.getHomePage().waitUntilAllSuggestedResultsPresent();
        List<String> suggestedResults = pageFactoryManager.getHomePage().getSuggestedResults();
        suggestedResults.forEach(suggestion ->
                assertThat(String.format("Search result suggestion should contain " +
                        "search word %s, search result suggestion %s", searchWord, suggestion),
                        suggestion, containsStringIgnoringCase(searchWord))
        );
    }

    private void clickOnNavBarLink(String link) {
        switch (NavBarLinks.from(link)) {
            case DOWNLOADS:
                pageFactoryManager.getHomePage().getNavBar().clickOnDownloadsLink();
                break;
            case DOCUMENTATION:
                pageFactoryManager.getHomePage().getNavBar().clickOnDocumentationLink();
                break;
        }
    }
}
