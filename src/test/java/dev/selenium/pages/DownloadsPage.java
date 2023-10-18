package dev.selenium.pages;

import dev.selenium.pageelements.Button;
import dev.selenium.pageelements.ContentContainer;
import dev.selenium.pages.commonpageelements.NavBar;
import org.openqa.selenium.WebDriver;

import java.util.List;

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

    public List<String> getListOfAvailableProgramingLanguages() {
        return supportedLanguages.getListOfTextFromElements();
    }

    public void waitUntilExpectedNumberOfSupportedLanguagesPresent(int numberOfElements) {
        super.waitUntilExpectedNumberOfElementsPresent(numberOfElements, supportedLanguages.getXPath());
    }

    public void waitUntilExpectedNumberOfBrowsersPresent(int numberOfBrowsers) {
        super.waitUntilExpectedNumberOfElementsPresent(numberOfBrowsers, supportedBrowsers.getXPath());
    }

    public void waitUntilBrowserButtonClickable() {
        super.waitUntilClickable(browsersButton.getXPath());
    }

    public void waitUntilAllBrowsersVisible() {
        super.waitUntilAllElementsVisible(supportedBrowsers.getXPath());
    }

    public void scrollSupportedProgramingLanguagesIntoView() {
        String firstElementDiv = "//parent::div//parent::div[@class='card h-100 bg-transparent border-0']";
        scrollIntoView(supportedLanguages.getXPath() + firstElementDiv);
    }

    public void scrollSupportedBrowsersIntoView() {
        scrollIntoView(supportedBrowsers.getXPath());
    }

    public void clickBrowserButtonWithJsScript() {
        browsersButton.clickWithJsScript();
    }

    public List<String> getListOfSupportedPlatforms() {
        return supportedBrowsers.getListOfTextFromElements();
    }
}
