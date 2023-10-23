package dev.selenium.pages;

import dev.selenium.pageelements.Button;
import dev.selenium.pageelements.Header;
import dev.selenium.pageelements.Link;
import dev.selenium.pageelements.Tab;
import dev.selenium.pages.commonpageelements.NavBar;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.Objects;

public class DocumentationPage extends BasePage {
    private NavBar navBar;
    private final Header tabButtons = new Header("//ul[@class='nav nav-tabs']", getDriver());
    private final Link viewFullExampleOnGitHub = new Link
            ("//a[contains(@href, 'https://github.com/SeleniumHQ/seleniumhq.github.io/blob/trunk//examples/java/')]",
                    getDriver());

    public DocumentationPage(WebDriver driver) {
        super(driver);
    }

    public Map<String,Button> getTabButtonsList() {
        return Map.of("java", new Button("//button[@class='nav-link active persistLang-Java']", getDriver()),
                "python", new Button("//button[@class='nav-link persistLang-Python']", getDriver()),
                "csharp", new Button("//button[@class='nav-link persistLang-CSharp']", getDriver()),
                "ruby", new Button("//button[@class='nav-link persistLang-Ruby']", getDriver()),
                "javascript", new Button("//button[@class='nav-link persistLang-JavaScript']", getDriver()),
                "kotlin", new Button("//button[@class='nav-link persistLang-Kotlin']", getDriver()));
    }

    public Map<String, Tab> getTabsList() {
        return Map.of("java", new Tab("//pre[@class=' language-java']", getDriver()),
                "python", new Tab("//pre[@class=' language-py']", getDriver()),
                "csharp", new Tab("//pre[@class=' language-cs']", getDriver()),
                "ruby", new Tab("//pre[@class=' language-rb']", getDriver()),
                "javascript", new Tab("//pre[@class=' language-js']", getDriver()),
                "kotlin", new Tab("//pre[@class=' language-kt']", getDriver()));
    }

    public void clickOnTabButton(String buttonName) {
        getTabButtonsList().get(buttonName).clickOnButton();
    }

    public void clickOnViewFullExampleOnGitHub() {
        viewFullExampleOnGitHub.clickOnLink();
    }

    public String getTextFromTab(String tabName) {
        String textFromTab = getTabsList().get(tabName).getText();
        if (Objects.equals(tabName, "csharp")) {
            textFromTab = textFromTab.replaceAll("\\s{12}\\n", "\n");
        }

        return textFromTab;
    }

    public void waitUntilTextTabVisible(String textTabName) {
        waitUntilAllElementsVisible(getTabsList().get(textTabName).getXPath());
    }

    public void waitUntilTabButtonClickable(String tabButtonName) {
        waitUntilClickable(getTabButtonsList().get(tabButtonName).getXPath());
    }

    public void waitUntilViewFullExampleOnGitHubIsClickable() {
        waitUntilClickable(viewFullExampleOnGitHub.getXPath());
    }

    public void scrollViewFullExampleOnGitHubIntoView() {
        scrollIntoView(viewFullExampleOnGitHub.getXPath());
    }

    public void scrollTabButtonsListIntoView() {
        scrollIntoView(tabButtons.getXPath());
    }
}
