package dev.selenium.stepdefinitions;

import dev.selenium.containers.PageFactoryContainer;
import dev.selenium.enums.NavBarLinks;
import dev.selenium.manager.PageFactoryManager;
import io.cucumber.java.en.When;

public class HomePageSteps {
    private final PageFactoryManager pageFactoryManager;

    public HomePageSteps(PageFactoryContainer pageFactoryManagerContainer) {
        this.pageFactoryManager = pageFactoryManagerContainer.getPageFactoryManager();
    }

    @When("^user clicks on (.*) link$")
    public void clicks_on_link(String link) {
        clickOnNavBarLink(link);
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
