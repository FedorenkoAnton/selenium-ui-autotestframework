package dev.selenium.stepdefinitions;

import dev.selenium.containers.PageFactoryContainer;
import dev.selenium.manager.PageFactoryManager;
import dev.selenium.pages.DownloadsPage;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class DownloadsPageStepDefinitions {
    private final DownloadsPage downloadsPage;

    public DownloadsPageStepDefinitions(PageFactoryContainer pageFactoryContainer) {
        this.downloadsPage = pageFactoryContainer.getPageFactoryManager().getDownloadPage();
    }

    @Then("user sees list of available programing languages")
    public void user_sees_list_of_available_programing_languages() {
        downloadsPage.waitUntilExpectedNumberOfElementsPresent(5);
        List<String> expectedAvailableProgramingLanguages = List.of("C#", "Ruby", "Java", "Python", "JavaScript");
        List<String> availableProgramingLanguages =
                downloadsPage.getListOfAvailableProgramingLanguages();
        assertThat(String.format(
                        "Actual list of available programing languages doesn't match with expected" +
                                " \n actual: %s \n expected: %s",
                        availableProgramingLanguages, expectedAvailableProgramingLanguages),
                availableProgramingLanguages, Matchers.is(Matchers.equalTo(expectedAvailableProgramingLanguages)));
    }
}
