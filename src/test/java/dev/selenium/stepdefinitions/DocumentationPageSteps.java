package dev.selenium.stepdefinitions;

import dev.selenium.containers.PageFactoryContainer;
import dev.selenium.pages.DocumentationPage;
import dev.selenium.utils.filereader.FileReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class DocumentationPageSteps {
    private final DocumentationPage documentationPage;

    public DocumentationPageSteps(PageFactoryContainer pageFactoryContainer) {
        this.documentationPage = pageFactoryContainer.getPageFactoryManager().getDocumentationPage();
    }

    @Then("user sees code snippets of programing languages")
    public void userSeesCodeSnippetsOfProgramingLanguages(DataTable dataTable) {
        List<String> programingLanguages = dataTable.asList(String.class);
        Map<String, String> expectedCodeSnippets = getCodeSnippetsExamples(programingLanguages);
        documentationPage.scrollTabButtonsListIntoView();
        for (var programingLanguage : programingLanguages) {
            String programingLanguageInLowerCase = programingLanguage.toLowerCase();
            documentationPage.waitUntilTabButtonClickable(programingLanguageInLowerCase);
            documentationPage.clickOnTabButton(programingLanguageInLowerCase);
            documentationPage.waitUntilTextTabVisible(programingLanguageInLowerCase);
            String actualTextInTab = documentationPage.getTextFromTab(programingLanguageInLowerCase);
            assertThat("Text from tab should be equal to expected",
                    actualTextInTab, Matchers.equalTo(expectedCodeSnippets.get(programingLanguageInLowerCase)));
        }
    }

    @And("^clicks on 'View full example on GitHub'")
    public void clicksOnViewFullExampleOnGitHub() {
        documentationPage.scrollViewFullExampleOnGitHubIntoView();
        documentationPage.waitUntilViewFullExampleOnGitHubIsClickable();
        documentationPage.clickOnViewFullExampleOnGitHub();
    }

    private Map<String, String> getCodeSnippetsExamples(List<String> programingLanguages) {
        FileReader fileReader = new FileReader();
        String pathPattern = "src/test/resources/testdata/codesnippets/%s.txt";

        return programingLanguages.stream()
                .collect(Collectors
                        .toMap(String::toLowerCase,
                                language -> fileReader.readFromFileCodeSnippets(String.format(pathPattern, language.toLowerCase()))));
    }
}
