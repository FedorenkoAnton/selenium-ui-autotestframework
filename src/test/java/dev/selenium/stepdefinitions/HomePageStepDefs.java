package dev.selenium.stepdefinitions;

import dev.selenium.containers.PageFactoryContainer;
import dev.selenium.manager.PageFactoryManager;
import io.cucumber.java.en.When;

public class HomePageStepDefs {
    private PageFactoryManager pageFactoryManager;

    public HomePageStepDefs(PageFactoryContainer pageFactoryManagerContainer) {
        this.pageFactoryManager = pageFactoryManagerContainer.getPageFactoryManager();
    }

    @When("clicks on Download link")
    public void clicks_on_link() {
        pageFactoryManager.getHomePage().getNavBar().clickOnDownloadsLink();
    }
}
