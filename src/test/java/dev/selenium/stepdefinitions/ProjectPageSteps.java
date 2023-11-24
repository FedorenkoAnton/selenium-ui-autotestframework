package dev.selenium.stepdefinitions;

import dev.selenium.containers.PageFactoryContainer;
import dev.selenium.containers.WebDriverContainer;
import dev.selenium.pageelements.Heading;
import dev.selenium.pages.ProjectsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;

public class ProjectPageSteps {
    private final ProjectsPage projectsPage;
    private final WebDriver driver;

    public ProjectPageSteps(PageFactoryContainer pageFactoryContainer, WebDriverContainer webDriverContainer) {
        this.projectsPage = pageFactoryContainer.getPageFactoryManager().getProjectsPage();
        this.driver = webDriverContainer.getDriver();
    }

    @Then("user can see following selenium projects")
    public void userCanSeeFollowingSeleniumProjects(DataTable dataTable) {
        List<String> expectedProjectsOnPage = dataTable.asList(String.class);
        List<Heading> actualProjectsOnPage = projectsPage.getAvailableProjects();
        String projectImageXPath = "/preceding-sibling::img";
        int elementDeltaY;
        int offset = 0;

        for (Heading projectName : actualProjectsOnPage) {
            String projectNameXPath = projectName.getXPath();
            projectsPage.waitUntilProjectDescriptionVisible(projectNameXPath);
            elementDeltaY = projectsPage.getElementDeltaY(projectName.getXPath() + projectImageXPath);
            projectsPage.scrollToProjectName(elementDeltaY, offset);
            offset = elementDeltaY;
            String actualProjectName = projectName.getHeadingText();
            assertThat(String.format("Expected %s is in list of expected projects: %s",
                    actualProjectName, String.join(",", expectedProjectsOnPage)),
                    actualProjectName, is(in(expectedProjectsOnPage)));
        }
    }
}
