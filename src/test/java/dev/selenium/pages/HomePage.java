package dev.selenium.pages;

import dev.selenium.pageelements.ContentContainer;
import dev.selenium.pageelements.Input;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePage extends BasePage {
    private final Input searchInput = new Input("//input[@class='DocSearch-Input']", getDriver());
    private final ContentContainer suggestedSearchResults =
            new ContentContainer("//span[@class='DocSearch-Hit-title']", getDriver());

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitUntilSearchInputVisible() {
        waitUntilAllElementsVisible(searchInput.getXPath());
    }

    public void waitUntilAllSuggestedResultsPresent() {
        waitUntilAllElementsVisible(suggestedSearchResults.getXPath());
    }

    public void inputTextIntoSearchField(String searchQuery) {
        searchInput.inputText(searchQuery);
    }

    public List<String> getSuggestedResults() {
        return suggestedSearchResults.getListOfTextFromElements();
    }
}
