package dev.selenium.pages;

import dev.selenium.pageelements.ContentContainer;
import dev.selenium.pages.commonpageelements.NavBar;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static dev.selenium.constants.TimeConstant.TIME_TO_WAIT;

public class DownloadsPage extends BasePage {
    private NavBar navBar;

    private static final String CONTENT_CONTAINER_XPATH = "//p[@class='card-title fw-bold h6']";

    public DownloadsPage(WebDriver driver) {
        super(driver);
    }

    private final ContentContainer contentContainer = new ContentContainer(CONTENT_CONTAINER_XPATH, getDriver());

    public void setNavBar(NavBar navBar) {
        this.navBar = navBar;
    }

    public List<String> getListOfAvailableProgramingLanguages() {
        return contentContainer.getListOfTextFromElements();
    }

    public void waitUntilExpectedNumberOfElementsPresent(int numberOfElements) {
        super.waitUntilExpectedNumberOfElementsPresent(TIME_TO_WAIT, numberOfElements, CONTENT_CONTAINER_XPATH);
    }
}
