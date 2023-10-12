package dev.selenium.stepdefinitions;

import dev.selenium.containers.PageFactoryContainer;
import dev.selenium.manager.PageFactoryManager;
import io.cucumber.java.en.When;

public class HomePageSteps {
    private PageFactoryManager pageFactoryManager;

    public HomePageSteps(PageFactoryContainer pageFactoryManagerContainer) {
        this.pageFactoryManager = pageFactoryManagerContainer.getPageFactoryManager();
    }

    @When("^user clicks on Download link$")
    public void clicks_on_link() {
        pageFactoryManager.getHomePage().getNavBar().clickOnDownloadsLink();
    }
}
