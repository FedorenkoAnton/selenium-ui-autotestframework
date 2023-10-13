package dev.selenium.pages;

import dev.selenium.pageelements.Button;
import dev.selenium.pageelements.ContentContainer;
import dev.selenium.pages.commonpageelements.NavBar;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static dev.selenium.constants.TimeConstant.TIME_TO_WAIT;

public class DownloadsPage extends BasePage {
    private NavBar navBar;

    public DownloadsPage(WebDriver driver) {
        super(driver);
    }

    private final ContentContainer supportedLanguages = new ContentContainer("//p[@class='card-title fw-bold h6']",
            getDriver());
    private final Button browsersButton = new Button(
            "//button[@aria-controls='supported-browsers']",
            getDriver());
    private final ContentContainer supportedBrowsers = new ContentContainer(
            "//div[@id='supported-browsers']//h4[@class='card-title fw-bold']", getDriver());

    public void setNavBar(NavBar navBar) {
        if (this.navBar == null) {
            this.navBar = navBar;
        }
    }

    public List<String> getListOfAvailableProgramingLanguages() {
        return supportedLanguages.getListOfTextFromElements();
    }

    public void waitUntilExpectedNumberOfSupportedLanguagesPresent(int numberOfElements) {
        super.waitUntilExpectedNumberOfElementsPresent(TIME_TO_WAIT, numberOfElements, supportedLanguages.getXPath());
    }

    public void waitUntilExpectedNumberOfBrowsersPresent(int numberOfBrowsers) {
        super.waitUntilExpectedNumberOfElementsPresent(TIME_TO_WAIT, numberOfBrowsers, supportedBrowsers.getXPath());
    }

    public void waitUntilBrowserButtonClickable() {
        super.waitUntilClickable(TIME_TO_WAIT, browsersButton.getXPath());
    }

    public void waitUntilAllBrowsersVisible() {
        super.waitUntilAllElementsVisible(TIME_TO_WAIT, supportedBrowsers.getXPath());
    }

    public void clickBrowserButtonWithJsScript() {
        browsersButton.clickWithJsScript();
    }

    public List<String> getListOfSupportedPlatforms() {
        return supportedBrowsers.getListOfTextFromElements();
    }
}
