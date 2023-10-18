package dev.selenium.stepdefinitions;

import dev.selenium.containers.PageFactoryContainer;
import dev.selenium.pages.DownloadsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class DownloadsPageSteps {
    private final DownloadsPage downloadsPage;
    private final static String listMismatchPattern =
            "Actual list of available %s doesn't match to expected \n actual: %s \n expected: %s";

    public DownloadsPageSteps(PageFactoryContainer pageFactoryContainer) {
        this.downloadsPage = pageFactoryContainer.getPageFactoryManager().getDownloadPage();
    }

    @Then("^user sees following programing languages$")
    public void user_sees_list_of_available_programing_languages(DataTable dataTable) {
        downloadsPage.waitUntilExpectedNumberOfSupportedLanguagesPresent(5);
        downloadsPage.scrollSupportedProgramingLanguagesIntoView();
        List<String> expectedAvailableProgramingLanguages = dataTable.asList(String.class);
        List<String> availableProgramingLanguages =
                downloadsPage.getListOfAvailableProgramingLanguages();
        assertThat(String.format(listMismatchPattern, "programing languages", availableProgramingLanguages,
                        expectedAvailableProgramingLanguages),
                availableProgramingLanguages, Matchers.is(Matchers.equalTo(expectedAvailableProgramingLanguages)));
    }

    @And("user clicks on Browser button")
    public void userClicksOnBrowserButton() {
        downloadsPage.waitUntilBrowserButtonClickable();
        downloadsPage.clickBrowserButtonWithJsScript();
    }

    @Then("user sees following list of supported browsers")
    public void userSeesFollowingListOfSupportedBrowsers(DataTable dataTable) {
        downloadsPage.waitUntilExpectedNumberOfBrowsersPresent(6);
        downloadsPage.scrollSupportedBrowsersIntoView();
        downloadsPage.waitUntilAllBrowsersVisible();
        List<String> supportedBrowsersOnPage = downloadsPage.getListOfSupportedPlatforms();
        List<String> expectedListOfBrowsers = dataTable.asList(String.class);
        assertThat(String.format(listMismatchPattern, "browsers", supportedBrowsersOnPage,
                        expectedListOfBrowsers),
                supportedBrowsersOnPage, Matchers.is(Matchers.equalTo(expectedListOfBrowsers)));
    }
}
