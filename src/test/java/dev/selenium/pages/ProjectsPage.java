package dev.selenium.pages;

import dev.selenium.pageelements.Heading;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProjectsPage extends BasePage {

    private final List<Heading> availableProjects = List.of(
            new Heading("//div[contains(@class, 'alert alert-webdriver')]//h2", getDriver()),
            new Heading("//div[contains(@class, 'alert alert-blue')]//h2", getDriver()),
            new Heading("//div[contains(@class, 'alert alert-purple')]//h2", getDriver()));

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public List<Heading> getAvailableProjects() {
        return this.availableProjects;
    }

    public void scrollToProjectName(int elementDeltaY, int offset) {
        scrollElementIntoViewWithOffset(elementDeltaY, offset);
    }

    public int getElementDeltaY(String xPath) {
        return super.getElementDeltaY(xPath);
    }

    public void waitUntilProjectDescriptionVisible(String xPath) {
        waitUntilAllElementsVisible(xPath);
    }
}
